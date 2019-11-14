package multithreading1.creationofthread;

//create thread by extending Thread class
class NewThread1 extends Thread {
	private String name;

	public NewThread1(String name) {
		super(name);
		System.out.println("constructor called");
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " running");
	}
}

//create thread by implementing Runnable
class NewThread2 implements Runnable {

	public NewThread2() {
		System.out.println("constructor called");
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " running");
	}
}

public class ThreadCreationDemo {

	public static void main(String[] args) {
		// create thread by extending Thread class
		NewThread1 t1 = new NewThread1("Thread1");
		t1.start();

		NewThread1 t2 = new NewThread1("Thread2");
		t2.start();

		// create thread by implementing Runnable
		NewThread2 rThread = new NewThread2();
		Thread thread = new Thread(rThread, "RunnableThread");
		thread.start();
	}

}
