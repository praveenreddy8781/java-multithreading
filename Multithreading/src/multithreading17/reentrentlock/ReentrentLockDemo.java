package multithreading17.reentrentlock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable {
	ReentrantLock reentrantLock;

	public Task(ReentrantLock reentrantLock) {
		this.reentrantLock = reentrantLock;
	}

	public void run() {
		boolean done = false;
		String name = Thread.currentThread().getName();
		while (!done) {
			// Getting Outer Lock
			boolean ans = reentrantLock.tryLock();

			// Returns True if lock is free
			if (ans) {
				try {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println(
							"task name - " + name + " outer lock acquired at " + ft.format(d) + " Doing outer work");
					Thread.sleep(1500);

					// Getting Inner Lock
					reentrantLock.lock();
					try {
						d = new Date();
						ft = new SimpleDateFormat("hh:mm:ss");
						System.out.println("task name - " + name + " inner lock acquired at " + ft.format(d)
								+ " Doing inner work");
						System.out.println("Lock Hold Count - " + reentrantLock.getHoldCount());
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						// Inner lock release
						System.out.println("task name - " + name + " releasing inner lock");

						reentrantLock.unlock();
					}
					System.out.println("Lock Hold Count - " + reentrantLock.getHoldCount());
					System.out.println("task name - " + name + " work done");

					done = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// Outer lock release
					System.out.println("task name - " + name + " releasing outer lock");

					reentrantLock.unlock();
					System.out.println("Lock Hold Count - " + reentrantLock.getHoldCount());
				}
			} else {
				System.out.println("task name - " + name + " waiting for lock");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

public class ReentrentLockDemo {

	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();

//		ReentrantLock reentrantLock = new ReentrantLock(true);

		Task task1 = new Task(reentrantLock);
		Task task2 = new Task(reentrantLock);
		Task task3 = new Task(reentrantLock);
		Task task4 = new Task(reentrantLock);

		ExecutorService pool = Executors.newFixedThreadPool(4);

		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);

		pool.shutdown();
	}

}
