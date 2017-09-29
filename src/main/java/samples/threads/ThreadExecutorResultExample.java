package samples.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * When executing threads with an {@link java.util.concurrent.ExecutorService},
 * like for example a {@link java.util.concurrent.ThreadPoolExecutor}, we
 * can retrieve values returned by the threads.
 */
public class ThreadExecutorResultExample {

	public static void main(String[] args) throws Exception {

		
		final ExecutorService executor = Executors.newFixedThreadPool(5);


		// Instead of Runnable, we use Callable, because
		// this interface has a method (call) with a return type.
		Callable<Integer> task = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return produceValue();
			}
		};

		// Submit returns a Future, that is something similar to a "promise".
		// This future will contain the result produced by the task.
		Future<Integer> result = executor.submit(task);

		ThreadUtil.println("Waiting for value...");
		Integer value = result.get();
		ThreadUtil.println("Got value: " + value);


		// Same as before but using a lambda
		Future<Integer> result2 = executor.submit(() -> produceValue());
		ThreadUtil.println("Waiting for the other value...");
		ThreadUtil.println("Got value: " + result2.get());


		executor.shutdown();
	}

	private static int produceValue() {

		ThreadUtil.println("Producing value, please wait...");
		ThreadUtil.sleep(2000);
		final int value = new Random().nextInt(10);
		ThreadUtil.println("Returning value: " + value);
		return value;
	}
}
