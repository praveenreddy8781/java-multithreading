package multithreading6.ThreadClass;

public class ThreadClassDemo {

	public static void main(String[] args) {
		Thread thread1 = new Thread("one");
		Thread thread2 = new Thread("two");
		Thread thread3 = new Thread("three");

		thread3.setPriority(10);

		thread1.start();
		thread2.start();
		thread3.start();

		System.out.println("activeThreads in current threads thread group: " + Thread.activeCount());
		System.out.println("currentThread: " + Thread.currentThread());
		System.out.println(thread1.toString());

//		thread1.dumpStack();

		System.out.println("getId: " + Thread.currentThread().getId());

		System.out.println("Thread name : " + Thread.currentThread().getName());

		System.out.println("getThreadGroup: " + Thread.currentThread().getThreadGroup());

		System.out.println("getPriority: " + Thread.currentThread().getPriority());

		System.out.println("getState: " + Thread.currentThread().getState());

		System.out.println("getContextClassLoader: " + Thread.currentThread().getContextClassLoader());

		System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted());

		System.out.println("thread1 isAlive: " + thread1.isAlive());

		System.out.println("isDaemon: " + Thread.currentThread().isDaemon());

		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sleep called");

		thread2.setDaemon(true);

		System.out.println("isDaemon: " + thread2.isDaemon());

		System.out.println("changed thread priority: " + thread3.getPriority());

	}

}
