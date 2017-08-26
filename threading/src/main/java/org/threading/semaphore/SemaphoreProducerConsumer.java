package org.threading.semaphore;

public class SemaphoreProducerConsumer {
	
	public static void main(String[] args) {
		//create Queue;
		ResourceQ q = new ResourceQ();
		
		//create producer and consumer thread
		Thread producer = new Thread(new Producer(q));
		Thread consumer = new Thread(new Consumer(q));
		
		//start thread
		producer.start();
		consumer.start();
	}

}
