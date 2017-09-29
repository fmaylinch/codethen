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

		System.out.println("Threads started!");
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++) {
				ThreadUtil.println("iteration " + i);
			}
		}
	}

}

