package multithreading8.threadpriority;

class Newthread extends Thread {
	String name;

	public Newthread(String name) {
		super(name);
		this.name = name;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing " + "With priority: "
				+ Thread.currentThread().getPriority());
	}
}

public class ThreadPriorityDemo {

	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread();

		// change the thread priority of the main thread
//		mainThread.setPriority(Thread.MAX_PRIORITY);

		System.out.println("Thread priority of the main thread: " + mainThread.getPriority());

		// create child thread
		Newthread t1 = new Newthread("one");

		t1.setPriority(5);

		// child thread thread priority is same as the main thread
//		System.out.println("t1 priority: " + t1.getPriority());

		// highest thread priority takes the preference
		Newthread t2 = new Newthread("two");

		t2.setPriority(2);

		Newthread t3 = new Newthread("three");

		t3.setPriority(10);

		t1.start();
		t2.start();
		t3.start();
	}

}
