package samples.threads;

public class ThreadWithRunnable {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 1; i <= 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        System.out.println("Starting the threads");

        // This starts the threads, but doesn't wait for them to finish
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Waiting for the threads");

        // This way we wait for the other threads
        t1.join();
        t2.join();
        t1.join();

        System.out.println("threads finished");
    }
}
