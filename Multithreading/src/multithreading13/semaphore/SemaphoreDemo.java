package multithreading13.semaphore;

import java.util.concurrent.Semaphore;

class SharedResource {
	static int count = 0;
}

class Newthread extends Thread {
	Semaphore semaphore;

	public Newthread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " waiting for permit");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			semaphore.acquire();
			
			System.out.println(Thread.currentThread().getName() + " got permit");

			SharedResource.count++;
			System.out.println(SharedResource.count);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		semaphore.release();
		System.out.println(Thread.currentThread().getName() + " released permit");
	}
}

public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(2);

//		Semaphore semaphore = new Semaphore(1, true);

		Newthread t1 = new Newthread(semaphore);
		Newthread t2 = new Newthread(semaphore);
		Newthread t3 = new Newthread(semaphore);

		t1.start();
//		t1.join();
		t2.start();
//		t2.join();
		t3.start();
//		t3.join();
	}

}
