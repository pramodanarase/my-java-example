package org.threading.semaphore;

public class EvenOddWriter {

	public static void main(String[] args) {
		SharedWriter writer = new SharedWriter();
		
		//task
		EvenWriter evenWriter = new EvenWriter(writer);
		OddWriter oddWriter = new OddWriter(writer);
		
		//
		Thread odd = new Thread(oddWriter);
		Thread even = new Thread(evenWriter);
		
		//
		odd.start();
		even.start();
	}
}
