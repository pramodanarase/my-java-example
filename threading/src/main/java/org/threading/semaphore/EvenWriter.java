package org.threading.semaphore;

import java.io.PrintWriter;

public class EvenWriter implements Runnable {

	SharedWriter writer;

	public EvenWriter(SharedWriter writer) {
		this.writer = writer;
	}

	@Override
	public void run() {
		for (int i = 2; i < 100; i++) {
			if (i % 2 == 0) {
				writer.writeEvenNumber(i);
			}
		}

	}

}
