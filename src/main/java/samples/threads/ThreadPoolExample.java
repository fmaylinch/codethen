package samples.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExample {

	public static void main(String[] args) {

		Runnable task = () -> {
			System.out.println("connect to database");
			sleep(2000);
			System.out.println("get information");
			sleep(2000);
			System.out.println("return information");
		};


		// Creates a pool of 3 threads
		final ExecutorService executor = Executors.newFixedThreadPool(3);


		// Takes one free thread and tells it to execute the task
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
	}


	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// nothing
		}
	}


}
