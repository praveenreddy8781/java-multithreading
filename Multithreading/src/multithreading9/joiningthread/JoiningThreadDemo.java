package multithreading9.joiningthread;

class Newthread extends Thread {

	String name;

	public Newthread(String name) {
		super(name);
		this.name = name;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " completed");
	}
}

public class JoiningThreadDemo {

	public static void main(String[] args) {
		Newthread t1 = new Newthread("Thread1");
		Newthread t2 = new Newthread("Thread2");
		Newthread t3 = new Newthread("Thread3");

		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t3.start();

		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Main thread complted");
	}

}
