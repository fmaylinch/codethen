package samples.threads;

public class ThreadUtil {

	/**
	 * Convenience method that calls {@link Thread#sleep(long)} and
	 * wraps the {@link InterruptedException} into a {@link RuntimeException}.
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException("I was interrupted!", e);
		}
	}

	/**
	 * Prints thread name and given message
	 */
	public static void println(String message) {
		System.out.println(Thread.currentThread().getName() + ": " + message);
	}
}
