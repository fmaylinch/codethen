package samples.threads.consume;

import samples.threads.ThreadUtil;

/**
 * Retrieves values from {@link Values}.
 */
public class Consumer implements Runnable {

	private final Values values;

	public Consumer(Values values) {
		this.values = values;
	}

	@Override
	public void run() {

		while (true) {

			try {

				int value;

				synchronized (values) {
					System.out.println("Waiting for value...");
					values.wait();
					System.out.println("I've been notified there's a new value");
					value = values.retrieveValue();
				}

				ThreadUtil.sleep(700);
				System.out.println("Value retrieved: " + value);

			} catch (InterruptedException e) {
				// TODO
			}
		}
	}
}
