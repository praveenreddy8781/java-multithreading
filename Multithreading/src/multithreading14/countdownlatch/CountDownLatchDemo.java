package multithreading14.countdownlatch;

import java.util.concurrent.CountDownLatch;

class Work implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : Running other task");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " : Running other task finished");
	}

}

class Newthread extends Thread {

	String name;
	CountDownLatch countDownLatch;
	int delay;

	public Newthread(String name, CountDownLatch countDownLatch, int delay) {
		this.name = name;
		this.countDownLatch = countDownLatch;
		this.delay = delay;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " started");

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Pending thread: " + countDownLatch.getCount());

		countDownLatch.countDown();

		System.out.println(Thread.currentThread().getName() + " finished");
	}
}

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(4);

		Newthread t1 = new Newthread("thread1", countDownLatch, 1000);
		Newthread t2 = new Newthread("thread2", countDownLatch, 2000);
		Newthread t3 = new Newthread("thread3", countDownLatch, 3000);
		Newthread t4 = new Newthread("thread4", countDownLatch, 4000);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread t5 = new Thread(new Work());
		t5.start();

	}

}
