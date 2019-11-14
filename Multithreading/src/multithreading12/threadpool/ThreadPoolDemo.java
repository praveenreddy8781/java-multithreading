package multithreading12.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {

	String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing " + name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " completed " + name);
	}

}

public class ThreadPoolDemo {

	public static void main(String[] args) {
		
		//create tasks
		Task task1 = new Task("task1");
		Task task2 = new Task("task2");
		Task task3 = new Task("task3");
		Task task4 = new Task("task4");

		// create the thread pool
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
//		ExecutorService pool = Executors.newCachedThreadPool();
		
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);

		// shutdown the pool
		pool.shutdown();
	}
}
