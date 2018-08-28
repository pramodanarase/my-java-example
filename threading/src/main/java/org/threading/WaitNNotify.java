package org.threading;

public class WaitNNotify {
	static int loop = 20;

	private static Object lock = new Object();
	private static Object lock2 = new Object();

	static class Task1 implements Runnable {

		public void run() {
			int i = 0;
			while (i < loop) {
				synchronized (lock) {
					lock.notifyAll();
					System.out.println("Task1- Thread:" + Thread.currentThread().getName() + " i=" + i);
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}

			}
			System.out.println("END Task1- Thread:" + Thread.currentThread().getName());
		}
	}

	static class Task2 implements Runnable {

		public void run() {
			int i = 0;
			while (i < loop) {
				synchronized (lock) {
					lock.notifyAll();

					System.out.println("Task2- Thread:" + Thread.currentThread().getName() + " i=" + i);
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			}
			System.out.println("END Task2- Thread:" + Thread.currentThread().getName());
		}
	}

	static class Task3 implements Runnable {

		public void run() {
			int i = 0;
			while (i < loop) {
				synchronized (lock) {
					lock.notifyAll();

					System.out.println("Task3- Thread:" + Thread.currentThread().getName() + " i=" + i);
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			}
			System.out.println("END Task3- Thread:" + Thread.currentThread().getName());

		}
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new Task1(), "T1");
		Thread t2 = new Thread(new Task2(), "T2");
		Thread t3 = new Thread(new Task3(), "T3");

		t1.start();
		t2.start();
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (lock) {
			lock.notifyAll();
		}
	}

}
