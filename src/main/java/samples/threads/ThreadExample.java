package samples.threads;

public class ThreadExample {

	public static void main(String[] args) {

		System.out.println( Thread.currentThread().getName() );


		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm another thread");
			}
		};

		Runnable runnable2 = () -> {
			System.out.println("I'm another thread");
		};


		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print(".");
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("+");
			}
		});

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("-");
			}
		});


		t1.start();
		t2.start();
		t3.start();
	}

	static class MyThread extends Thread {

		public MyThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println("I'm a new thread: " + getName());
			for (int i = 0; i < 100; i++) {
				System.out.println(getName() + " - " + i);

			}
		}
	}
}

