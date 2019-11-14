package multithreading11.producerconsumer;

import java.util.LinkedList;

class PC {

	private LinkedList<Integer> list = new LinkedList<Integer>();

	private int capacity = 1;
	private int data = 0;

	public void producer() throws InterruptedException {
		synchronized (this) {
			while (true) {
				while (list.size() == capacity)
					wait();

				System.out.println("prodecer produced : " + data);
				list.add(data++);
				notify();
				
				Thread.sleep(1000); 
			}
		}
	}

	public void consumer() throws InterruptedException {
		synchronized (this) {
			while (true) {
				while (list.isEmpty())
					wait();

				int val = list.removeFirst();
				System.out.println("Consumer consumed: " + val);
				notify();
				
				Thread.sleep(1000); 
			}
		}
	}
}

public class ProducerConsumerDemo {

	public static void main(String[] args) throws InterruptedException {

		PC pc = new PC();

		Thread pt = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread ct = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		pt.start();
		ct.start();

		pt.join();
		ct.join();
	}

}
