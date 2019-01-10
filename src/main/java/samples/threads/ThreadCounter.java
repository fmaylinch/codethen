package samples.threads;

public class ThreadCounter {

    public static void main(String[] args) throws InterruptedException {

        // This is an object, so it's in the heap, which is shared by all threads
        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 1; i <= 1_000_000; i++) {

                // Only one thread can enter this block at the same time.
                // Otherwise threads will modify the value at the same time and will mess the result.
                synchronized (counter) {
                    long value = counter.getValue();
                    counter.setValue(value + 1);
                }

            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println(counter.getValue());
    }
}

class Counter {

    private long value = 0;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
