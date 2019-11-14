package multithreading5.interthreadcommuncation;

import java.util.Scanner;

class PC {
	public void consumer() {
		synchronized (this) {
			System.out.println("consumer thread started");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("consumer thread completed");
		}
	}

	public void producer() {
		Scanner scanner = new Scanner(System.in);
		synchronized (this) {
			System.out.println("producer thread started");
			
			scanner.nextLine();
			
			notify();
			System.out.println("producer thread completed");
		}
	}
}

class CT extends Thread {
	PC pc;

	public CT(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		pc.consumer();
	}
}

class PT extends Thread {

	PC pc;

	public PT(PC pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		pc.producer();
	}
}

//producer and consumer thread
public class InterThreadCommunicationDemo {

	public static void main(String[] args) {
		
		PC pc = new PC();
		
		PT pt = new PT(pc);
		CT ct = new CT(pc);

		ct.start();
		pt.start();

		try {
			ct.join();
			pt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
