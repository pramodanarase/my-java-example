package org.threading.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Resource Q will be gaurded by semaphore for concurrency it will have method
 * to get and put item
 * 
 * @author pramod
 *
 */

public class ResourceQ {
	int item;
	Semaphore semaProd = new Semaphore(1);
	//give producer first turn
	Semaphore semaCon = new Semaphore(0);

	// put item will by producer
	public void put(int item) {
		try {
			// aquire producer permit
			semaProd.acquire();
			this.item = item;
			System.out.println("Produced: " + item);
			// notify consumer
			semaCon.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// get will called by consumer
	public int get() {
		try {
			// aquire consumer permit
			semaCon.acquire();
			System.out.println("Consumed: " + item);
			// notify producer
			semaProd.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return item;
	}

}
