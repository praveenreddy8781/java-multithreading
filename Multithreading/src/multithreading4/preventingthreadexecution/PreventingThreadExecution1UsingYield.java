package multithreading4.preventingthreadexecution;

class NewThread implements Runnable {
	public NewThread() {

	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " completed its execution");
	}
}

public class PreventingThreadExecution1UsingYield {

	public static void main(String[] args) {

		NewThread rThread = new NewThread();
		Thread t1 = new Thread(rThread, "Thread1");
		t1.start();

		for (int i = 0; i < 5; i++) {
			// Control passes to child thread
			Thread.yield();

			// After execution of child Thread
			// main thread takes over
			System.out.println(Thread.currentThread().getName() + " in control");
		}
		System.out.println("main thread completed");

	}

}
