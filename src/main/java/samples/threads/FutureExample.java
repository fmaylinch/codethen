package samples.threads;

import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // If a task has a result, we use a Callable instead of a Runnable
        Callable<Long> sumTask = () -> {
            long result = 0;
            for (long i = 1; i <= 5_000_000_000L; i++) {
                result += i;
            }
            return result; // This the result of the task
        };

        // This creates 10 threads, waiting for tasks to do
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // We submit a task, that will be done when a thread is free.
        // Actually, the are threads are free now, because we didn't send any task before.
        Future<Long> future = executorService.submit(sumTask);

        System.out.println("task submitted");

        System.out.println("Waiting for the result");
        long result = future.get(); // This will wait for the thread to finish, and get the result
        System.out.println("The result is " + result);

        // Will stop the threads in the pool, so the program stops
        executorService.shutdown();
    }
}
