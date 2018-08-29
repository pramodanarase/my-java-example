package org.system.design.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolDesign {

	// define thread pool size
	private static int THREAD_POOL_SIZE = 2;

	// define one store for runnable object
	// which provide me the task in queue format (FIFO)
	static BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(THREAD_POOL_SIZE);
    
	//store reference of threads
	static Thread[] threadPool = new Thread[THREAD_POOL_SIZE];

	//shutdown notification flag
	static volatile boolean threadPoolShutdown = false;

	static {
		Thread t = null;
		// create and start the thread to process task
		for (int i = 0; i < THREAD_POOL_SIZE; i++) {
			t = new Thread(new RunPoolThread(), "Thread :" + i);
			threadPool[i] = t;
			t.start();
		}

	}

	// add task in queue
	public void execute(Runnable task) throws InterruptedException {
		taskQueue.put(task);
	}

	public static void shutDown() {
		threadPoolShutdown = true;
		
		//interupt thread waiting on queue
		for (Thread t : threadPool) {
			t.interrupt();
		}

	}

	//

	static class RunPoolThread implements Runnable {
		@Override
		public void run() {
			try {
				while (!threadPoolShutdown) {
					Runnable task = taskQueue.take();
					task.run();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolDesign threadPoolDesign = new ThreadPoolDesign();

		threadPoolDesign.execute(new Task(1));
		threadPoolDesign.execute(new Task(2));
		threadPoolDesign.execute(new Task(3));
		threadPoolDesign.execute(new Task(4));

		Thread.sleep(1000);

		ThreadPoolDesign.shutDown();
	}

	static class Task implements Runnable {
		int taskId;

		public Task(int taskId) {
			this.taskId = taskId;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " Task:" + taskId);

		}
	}

}
