package multithreading18.cyclickbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Work implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " :Now Runnable of CyclicBarrier get executed");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " : Now Runnable of CyclicBarrier finished");
	}

}

class Task1 extends Thread {

	CyclicBarrier barrier;
	int delay;

	public Task1(CyclicBarrier barrier, int delay) {
		this.barrier = barrier;
		this.delay = delay;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " started Task1");

		sleep(delay);

		System.out.println(Thread.currentThread().getName() + " : Waiting for other threads to come to this barrier");

		sleep(delay);

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " finished Task1");
	}

	private void sleep(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Task2 extends Thread {

	CyclicBarrier barrier;
	int delay;

	public Task2(CyclicBarrier barrier, int delay) {
		this.barrier = barrier;
		this.delay = delay;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " started Task2");

		try {
			sleep(delay);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " : Waiting for other threads to come to this barrier");

		try {
			sleep(delay);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " finished Task2");
	}
}
	class Task3 extends Thread {

		CyclicBarrier barrier;
		int delay;

		public Task3(CyclicBarrier barrier, int delay) {
			this.barrier = barrier;
			this.delay = delay;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + " started Task3");

			try {
				sleep(delay);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out
					.println(Thread.currentThread().getName() + " : Waiting for other threads to come to this barrier");

			try {
				sleep(delay);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " finished Task3");
		}
	}

public class CyclickBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new Work());

		Task1 task1 = new Task1(barrier, 2000);
		Task2 task2 = new Task2(barrier, 2000);
		Task3 task3 = new Task3(barrier, 2000);

		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);

		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Main thread finished");
	}
}
