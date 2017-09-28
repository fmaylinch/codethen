package samples.threads.consume;

import samples.threads.ThreadUtil;

public class ConsumeProduceExample {

	public static void main(String[] args) {

		// Here I will put values
		Values values = new Values();


		// Producer threads
		Producer producer = new Producer(values);

		// Consumer threads
		Consumer consumer = new Consumer(values);

		Thread producerThread = new Thread(() -> {
			producer.doWork();
		});

		Thread consumerThread = new Thread(consumer);

		consumerThread.start();

		ThreadUtil.sleep(2000);

		producerThread.start();
	}
}
