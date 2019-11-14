package multithreading19.callableandfuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Random random = new Random();
		int randomNumber = random.nextInt(5);

		Thread.sleep(randomNumber * 1000);

		return randomNumber;
	}
}

public class CallableFutureDemo {

	public static void main(String[] args) {
		CallableExample callable = new CallableExample();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

		Thread t1 = new Thread(futureTask);

		t1.start();

		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
