package org.threading;

public class SuperClassA {
	
	private int i =0 ;

	/**
	 * static synchronized method acquire lock on class level i.e
	 * SuperClassA.class
	 */
	public static synchronized void staticMethod1() {
		System.out.println("inside staticMethod1");

	}

	/**
	 * this method will acquire lock on calling Object
	 */
	public synchronized void method2() {
		System.out.println("inside method2");
	}

	/**
	 * this method will acquire lock on calling Object
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
		
		SuperClassA superClassA = new SuperClassA();
		
		superClassA.staticMethod1();
		superClassA.method2();
		
		superClassA.method3();
		
	}

}
