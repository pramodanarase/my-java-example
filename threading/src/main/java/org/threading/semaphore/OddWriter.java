package org.threading.semaphore;

public class OddWriter implements Runnable {
	SharedWriter writer;

	public OddWriter(SharedWriter writer) {
		this.writer = writer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {
				writer.writeOddNumber(i);
			}
		}

	}

}
