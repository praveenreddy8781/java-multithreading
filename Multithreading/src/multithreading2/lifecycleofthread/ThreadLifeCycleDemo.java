package multithreading2.lifecycleofthread;

class NewThread implements Runnable {

	@Override
	public void run() {
		System.out.println("State of thread after calling start(): " + Thread.currentThread().getState());
	}
}

public class ThreadLifeCycleDemo {

	public static void main(String[] args) {
		NewThread newThread = new NewThread();
		Thread t1 = new Thread(newThread);
		System.out.println("State of thread before calling start(): " + t1.getState());
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("State of thread after completing run(): " + t1.getState());
	}

}
