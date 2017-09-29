package samples.threads;

/**
 * Program showing different ways of creating threads using
 * {@link Thread} and {@link Runnable}.
 *
 * Also pausing them with {@link Thread#sleep(long)}.
 *
 * More information in the Java tutorial:
 * https://docs.oracle.com/javase/tutorial/essential/concurrency
 */
public class ThreadExamples {

	public static void main(String[] args) {

		// When I program is executed, one thread is created automatically.
		// Each thread has a name (the default one is called "main").
		// This way we can see the name of the thread we're in:
		System.out.println( "Current thread name: " + Thread.currentThread().getName() );

		// I've made this simple util method to display the current thread name
		ThreadUtil.println("Hello!");


		// To create a thread we use the Thread class and
		// we start it with start()

		// There are different ways to tell this thread what to do.


		// Option 1: extending Thread

		// Extend Thread using a normal class
		Thread t1a = new MyThread("my-thread-1a");
		t1a.start();

		// Extend Thread using an anonymous class
		Thread t1b = new Thread("my-thread-1b") {
			@Override
			public void run() {
				ThreadUtil.println("I'm an anonymous class extending Thread");
			}
		};
		t1b.start();


		// Option 2: pass a Runnable to Thread

		// Implement Runnable using a normal class
		Runnable runnable2a = new MyRunnable();
		Thread t2a = new Thread(runnable2a, "my-thread-2a");
		t2a.start();

		// Implement Runnable using an anonymous class
		Runnable runnable2b = new Runnable() {
			@Override
			public void run() {
				ThreadUtil.println("I'm an anonymous class implementing Runnable");
			}
		};
		Thread t2b = new Thread(runnable2b, "my-thread-2b");
		t2b.start();

		// Implement Runnable using an anonymous class (in lambda form)
		Runnable runnable2c = () -> {
			ThreadUtil.println("I'm a lambda implementing Runnable");
		};
		Thread t2c = new Thread(runnable2c, "my-thread-2c");
		t2c.start();

		// Same as before, but inlining the lambda and calling start() directly
		// Note here I don't set a thread name (although I could);
		//  in that case an auto-generated name will be assigned.
		new Thread(() -> {
			ThreadUtil.println("I'm a lambda (inline) implementing Runnable");
		}).start();



		// You can pause a thread using the sleep() method

		new Thread(() -> {

			int pauseInSecs = 3;

			ThreadUtil.println("Pausing for " + pauseInSecs + " seconds");

			try {
				Thread.sleep(pauseInSecs * 1000);
			} catch (InterruptedException e) {
				ThreadUtil.println("I've been interrupted");
			}

			// The sleep method throws an exception so we need a try/catch.
			// That's annoying so I created a convenience method:

			ThreadUtil.println("Pausing for another " + pauseInSecs + " seconds");
			ThreadUtil.sleep(pauseInSecs * 1000);

			ThreadUtil.println("This is the last sentence so I'm finishing");

		}).start();


		// The main thread ends here, but notice a program doesn't stop
		// until all threads finish.
		ThreadUtil.println("All threads started");
	}



	// Note the following classes are declared inside the main class in this file.
	// These are called inner classes.
	// In Java you usually want to declare them as `static`,
	// otherwise you would only be able to use them inside non-static methods.


	/** Extend {@link Thread} and indicate what to do in {@link #run()} */
	static class MyThread extends Thread {

		public MyThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			ThreadUtil.println("I'm extending Thread");
		}
	}

	/** Implement {@link Runnable} and indicate what to do in {@link #run()} */
	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			ThreadUtil.println("I'm implementing Runnable");
		}
	}
}

