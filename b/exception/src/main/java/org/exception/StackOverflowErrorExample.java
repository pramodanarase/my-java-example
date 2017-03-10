package org.exception;

/**
 * 
 * @author pramod.anarase
 *
 */

public class StackOverflowErrorExample {
  private int i = 0;
	
	/**
	 *  -XX:ThreadStackSize=512 is the parameter to specify size for each thread stack
	 */
	public synchronized void method3() {
		System.out.println("inside method3");		
		method4();
	}

	public synchronized void method4() {
		System.out.println("inside method4:"+ i++);
		method4();
	}
	
	public static void main(String[] args) {
		
		StackOverflowErrorExample stackOverflowErrorExample = new StackOverflowErrorExample();
		stackOverflowErrorExample.method3();
		
	}

}
