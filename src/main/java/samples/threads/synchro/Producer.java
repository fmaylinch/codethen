package samples.threads.synchro;

import samples.threads.ThreadUtil;

/**
 * Generates values and puts them into {@link Values}.
 */
public class Producer implements Runnable {

	private final Values values;

	/** Fake time that the producer takes to produce a new value */
	private final long fakeDelay;

	public Producer(Values values, long fakeDelay) {
		this.values = values;
		this.fakeDelay = fakeDelay;
	}

	@Override
	public void run() {

		for (int i = 1; i < 5; i++) {

			ThreadUtil.println("Producing value...");
			ThreadUtil.sleep(fakeDelay);
			final int value = i;
			ThreadUtil.println("Value produced: " + value);

			// We don't do the processing work inside the synchronized zone
			// Synchronized zones should be as small as possible;
			// only for when we need to touch the shared object `values`.

			// synchronized block, only 1 thread can be running inside
			synchronized (values) {
				values.addValue(value);
				ThreadUtil.println("Notify in case some thread is waiting");
				values.notify();
			}
		}
	}
}
