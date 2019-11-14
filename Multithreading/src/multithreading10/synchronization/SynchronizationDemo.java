package multithreading10.synchronization;

class Sender {
	public void send(String msg) {
		synchronized (this) {
			System.out.println("Sending\t" + msg);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("" + msg + " sent");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	public synchronized void send(String msg) {
//		System.out.println("Sending\t" + msg);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("" + msg + " sent");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

class NewThread implements Runnable {

	String msg;
	Sender sender;

	public NewThread(String msg, Sender sender) {
		this.msg = msg;
		this.sender = sender;
	}

	@Override
	public void run() {
		sender.send(msg);
	}
}

public class SynchronizationDemo {

	public static void main(String[] args) {
		Sender sender = new Sender();
		NewThread rThread1 = new NewThread("Hiiiii", sender);
		NewThread rThread2 = new NewThread("Byeeee", sender);

		Thread t1 = new Thread(rThread1);
		Thread t2 = new Thread(rThread2);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
