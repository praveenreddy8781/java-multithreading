package multithreading15.deadlock;

class Shared {
	public synchronized void test1(Shared s2) throws InterruptedException {
		System.out.println("test1() called");
		Thread.sleep(1000);
		s2.test2(this);
		System.out.println("test1() end");
	}

	public synchronized void test2(Shared s1) throws InterruptedException {
		System.out.println("test2() called");
		Thread.sleep(1000);
		s1.test1(this);
		System.out.println("test2() end");
	}
}

class Newthread1 extends Thread {
	Shared s1;
	Shared s2;

	public Newthread1(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		try {
			s1.test1(s2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Newthread2 extends Thread {
	Shared s1;
	Shared s2;

	public Newthread2(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	public void run() {
		try {
			s2.test2(s1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class DeadLockDemo {

	public static void main(String[] args) throws InterruptedException {
		Shared s1 = new Shared();
		Shared s2 = new Shared();

		Newthread1 t1 = new Newthread1(s1, s2);
		Newthread2 t2 = new Newthread2(s1, s2);

		t1.start();
//		t1.join();
		t2.start();
//		t2.join();
	}

}
