package samples.threads.synchro;

/**
 * Example with {@link Producer} and {@link Consumer} threads that
 * synchronize over an object (here {@link Values}).
 */
public class SynchronizedExample {

	public static void main(String[] args) {

		// All threads will use this object
		Values values = new Values();

		// Producer thread
		Producer producer = new Producer(values, 500);
		Thread producerThread = new Thread(producer, "producer1");

		// Consumer thread
		Consumer consumer = new Consumer(values, 200);
		Thread consumerThread = new Thread(consumer, "consumer1");

		producerThread.start();
		consumerThread.start();


		// You can also start more producer or consumer threads!
	}
}
