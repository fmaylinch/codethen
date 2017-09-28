package samples.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExecutorsExample {

	public static void main(String[] args) throws Exception {

		final ExecutorService executor = Executors.newFixedThreadPool(5);

		executor.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello from thread " + Thread.currentThread().getName());
			}
		});

		Future<Integer> result = executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("Producing value, please wait...");
				sleep(2000);
				System.out.println("Returning value!");
				return new Random().nextInt(10);
			}
		});

		System.out.println("Waiting for value...");
		Integer value = result.get();
		System.out.println("Got value: " + value);

		executor.shutdown();
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException("Interrupted!");
		}
	}
}
