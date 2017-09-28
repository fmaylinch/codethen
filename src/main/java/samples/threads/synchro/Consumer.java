package samples.threads.synchro;

import samples.threads.ThreadUtil;

/**
 * Retrieves values from {@link Values}.
 */
public class Consumer implements Runnable {

	private static long TIME_OUT = 5000;

	private final Values values;

	/** Fake time that the consumer takes to process a new value */
	private final long fakeDelay;

	public Consumer(Values values, long fakeDelay) {
		this.values = values;
		this.fakeDelay = fakeDelay;
	}

	@Override
	public void run() {

		while (true) {

			try {

				int value;

				// synchronized block, only 1 thread can be running inside
				synchronized (values) {

					if (values.isEmpty()) {

						ThreadUtil.println("Waiting for values to be produced...");
						values.wait(TIME_OUT); // Time out is optional (otherwise, waits forever)
						ThreadUtil.println("Woke up!"); // may be due to notify() or because time out passed

						// This may happen if we set a time out in wait()
						if (values.isEmpty()) {
							ThreadUtil.println("There are no more values, so I guess I can finish");
							return;
						}
					}

					value = values.retrieveValue();
				}
				// here we can already exit the synchronized zone
				// because we don't need `values` anymore (until next loop iteration)

				ThreadUtil.println("Processing value: " + value);
				ThreadUtil.sleep(fakeDelay);
				ThreadUtil.println("Value processed: " + value);

			} catch (InterruptedException e) {
				// TODO
			}
		}
	}
}
