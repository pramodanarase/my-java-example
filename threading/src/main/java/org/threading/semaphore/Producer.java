package org.threading.semaphore;

//producer worker will put item in resourceQ
public class Producer implements Runnable {

	ResourceQ q;

	public Producer(ResourceQ q) {
		this.q = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			q.put(i);
		}

	}

}
