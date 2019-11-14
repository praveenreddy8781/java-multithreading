package multithreading16.daemonthread;

class Daemonthread implements Runnable {

	public Daemonthread() {
//		System.out.println("Daemonthread created");
	}

	@Override
	public void run() {
		System.out.println("Daemonthread running");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Daemonthread finished its execution");
	}

}

public class DaemonThreadDemo {

	public static void main(String[] args) {
		
//		Thread.currentThread().setDaemon(true);
		
		Daemonthread rDaemonthread = new Daemonthread();

		Thread t1 = new Thread(rDaemonthread);

		t1.setDaemon(true);

		t1.start();

//		t1.setDaemon(true);

	}

}
