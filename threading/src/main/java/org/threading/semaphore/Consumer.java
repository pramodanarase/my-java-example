package org.threading.semaphore;

//consumer will consume item from q
public class Consumer implements Runnable {

	ResourceQ q;

	public Consumer(ResourceQ q) {
		this.q = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			q.get();
		}

	}

}
