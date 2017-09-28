package samples.threads;

public class ThreadSimpleExample {

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();

		t1.start();
		t2.start();

		System.out.println("Threads started!");
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				System.out.println(i);
			}
		}
	}

}

