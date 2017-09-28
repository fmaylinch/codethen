package samples.threads.consume;

import samples.threads.ThreadUtil;

/**
 * Generates values and puts them into {@link Values}.
 */
public class Producer {

	private final Values values;

	public Producer(Values values) {
		this.values = values;
	}

	public void doWork() {

		for (int i = 1; i < 10; i++) {

			System.out.println("Producing value: " + i);
			ThreadUtil.sleep(1000);

			// synchronized block
			synchronized (values) {
				values.addValue(i);
				System.out.println("Notify to any thread that may be waiting");
				values.notify();
			}
		}
	}
}
