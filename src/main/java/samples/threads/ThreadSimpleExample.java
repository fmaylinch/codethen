package samples.threads;

/**
 * Program creating 3 threads that print numbers from 1 to 100
 */
public class ThreadSimpleExample {

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();

		t1.start();
		t2.start();
		t3.start();

		ThreadUtil.println("Threads started!");
	}

	// Although this is not related to threads, note that the following class
	// is declared inside the main class in this file. These are called inner classes.
	// In Java you usually want to declare them as `static`,
	// otherwise you would only be able to instantiate them inside non-static methods.
	// For more info: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++) {
				ThreadUtil.println("iteration " + i);
			}
		}
	}

}

