package multithreading3.mainthread;

public class MainthreadDemo {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread);
		System.out.println("getId: " + mainThread.getId());
		System.out.println("getName: " + mainThread.getName());
		System.out.println("getPriority: " + mainThread.getPriority());
		System.out.println("getThreadGroup: " + mainThread.getThreadGroup());
		System.out.println("getState: " + mainThread.getState());
		System.out.println("isAlive: " + mainThread.isAlive());
		System.out.println("isDaemon: " + mainThread.isDaemon());

		// deadlock
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
