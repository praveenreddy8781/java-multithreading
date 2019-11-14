package multithreading4.preventingthreadexecution;

class NewThread2 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " completed ");
	}

}

public class PreventingThreadExecution3UsingJoin {

	public static void main(String[] args) {
		NewThread2 rThread = new NewThread2();
		Thread t1 = new Thread(rThread, "Thread1");

		Thread t2 = new Thread(rThread, "Thread2");

		t1.start();
		t2.start();

		try {
			System.out.println("thread2 is alive?: " + t2.isAlive());
			t2.join();
			System.out.println("thread2 is alive?: " + t2.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Main thread completed");
	}

}
