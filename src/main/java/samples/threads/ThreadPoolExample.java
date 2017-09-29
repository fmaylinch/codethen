package samples.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example of creating a pool of threads to optimize.
 *
 * If we have to perform tasks repeatedly, it is faster to create
 * a pool (group) of threads and reuse them.
 *
 * The only downside is that if we create a pool of N threads we
 * can only execute N tasks in concurrently, but maybe that's what
 * we want, to avoid putting too much pressure on the system.
 */
public class ThreadPoolExample {

	public static void main(String[] args) {

		// Creates a pool of 3 threads
		ThreadUtil.println("Creating pool of threads");
		final ExecutorService executor = Executors.newFixedThreadPool(3);

		// This is a fake task that a thread will perform
		Runnable task = () -> {
			Random random = new Random();
			ThreadUtil.println("connect to database");
			ThreadUtil.sleep(random.nextInt(3000)); // sleep randomly from 0 to 3 secs
			ThreadUtil.println("get information");
			ThreadUtil.sleep(random.nextInt(3000));
			ThreadUtil.println("return information");
		};

		// Each submit takes one free thread and tells it to execute the task.
		// You'll notice only 3 tasks (threads) run at the same time.
		ThreadUtil.println("Submitting tasks!");
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);
		executor.submit(task);


		executor.shutdown();
		ThreadUtil.println("All threads in the pool will be stopped when all tasks are performed");
	}
}
