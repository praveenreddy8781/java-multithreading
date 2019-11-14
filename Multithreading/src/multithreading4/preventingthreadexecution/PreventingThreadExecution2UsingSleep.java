package multithreading4.preventingthreadexecution;

class NewThread1 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " started ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " completed ");
	}
	
}

public class PreventingThreadExecution2UsingSleep {

	public static void main(String[] args) {
		NewThread1 rThread = new NewThread1();
		Thread t1 = new Thread(rThread, "Thread1");
		
		Thread t2 = new Thread(rThread, "Thread2");
		
		t1.start();
		t2.start();

	}

}
