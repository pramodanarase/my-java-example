package org.threading.semaphore;

import java.util.concurrent.Semaphore;

public class SharedWriter {
	Semaphore even = new Semaphore(0);
	//first turn of odd number
	Semaphore odd = new Semaphore(1);
	
	public void writeOddNumber(int num){
		try {
			odd.acquire();
			System.out.println("Odd Thread: "+num);
			even.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeEvenNumber(int num){
		try {
			even.acquire();
			System.out.println("Even Thread: "+num);
			odd.release();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
