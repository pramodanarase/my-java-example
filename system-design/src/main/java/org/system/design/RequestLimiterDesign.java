package org.system.design;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RequestLimiterDesign {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner input = new Scanner(System.in);
		// read client-id
		String clientId = input.next();
		if (clientId == null || clientId.length() == 0) {
			throw new APPException("invalid request");
		}

		RateLimiterManager rateLimiterManager = new RateLimiterManager();
		for(int i=0;i<100 ;i++) {
			rateLimiterManager.serve("client1");
		}

	}

}

// driver class to manage the ratelimit
class RateLimiterManager {
	// thread-safe collection
	private static final Map<String, RateLimiter> limiter = new ConcurrentHashMap();

	static {
		// pre loade licence info
		limiter.put("client1", RateLimiter.createRateLimiter(LicenceType.MEDIUM.getValue(), TimeUnit.SECONDS));
	}

	public void serve(String clientId) {
		// get the ratelimiter if clinet have valid licence
		RateLimiter rateLimiter = getRateLimiter(clientId);
		if (rateLimiter == null) {
			throw new APPException("clinet dose not have valid licence");
		}
		System.out.println("clinet1 has valid licence");
		// try to aquire the thread to serve the reuest
		boolean allowedRequest = rateLimiter.tryAquire();
		if (!allowedRequest) {
			throw new APPException("request call limit is exceeds");
		}
	}

	// rerurn valid client rateLimiter
	private RateLimiter getRateLimiter(String clientId) {
		RateLimiter result = limiter.entrySet().stream().filter(e -> e.getKey().equals(clientId))
				.map(Map.Entry::getValue).findFirst().orElse(null);
		return result;
	}

}

// custom unchecked excpetion to return custom message
class APPException extends RuntimeException {

	public APPException(String message) {
		super(message);
	}
}

class RateLimiter {
	// how many resource to aquireed
	private Semaphore semaphore;
	// max permits
	private int maxPermits;
	// bound time
	private TimeUnit timePeriod;

	// Thread pool service to excute process
	private ScheduledExecutorService scheduler;

	// create limiter and attach to scheduler
	public static RateLimiter createRateLimiter(int permits, TimeUnit timePeriod) {
		RateLimiter limiter = new RateLimiter(permits, timePeriod);
		limiter.scheduleTask();
		return limiter;
	}

	private RateLimiter(int permits, TimeUnit timePeriod) {
		this.semaphore = new Semaphore(permits);
		this.timePeriod = timePeriod;
		this.maxPermits = permits;
	}

	// aquire resource
	public boolean tryAquire() {
		return semaphore.tryAcquire();
	}

	public void scheduleTask() {
		scheduler = Executors.newScheduledThreadPool(1);
		// runnable, initdelay, period, timeout
		final Runnable task = new Runnable() {
			public void run() {
				semaphore.release(maxPermits - semaphore.availablePermits());
			}
		};
		scheduler.scheduleAtFixedRate(task, 1, 1, timePeriod);
	}
}

enum LicenceType {
	LOW(10), MEDIUM(20), HIGH(50);
	private int requestLimit;

	LicenceType(int requestLimit) {
		this.requestLimit = requestLimit;
	}

	public int getValue() {
		return this.requestLimit;
	}
}
