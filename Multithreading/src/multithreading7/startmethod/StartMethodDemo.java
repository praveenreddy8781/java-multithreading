package multithreading7.startmethod;

class Newthread extends Thread {

	public void run() {
		System.out.println(
				Thread.currentThread().getName() + " is executing" + " id : " + Thread.currentThread().getId());
	}
}

public class StartMethodDemo {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Newthread newthread = new Newthread();
//			newthread.run();
			newthread.start();
		}

	}

}
