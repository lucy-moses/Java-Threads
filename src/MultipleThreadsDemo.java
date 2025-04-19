/**
 * Demonstrates multiple threads running concurrently
 */
public class MultipleThreadsDemo {
    public static void demo() {
        System.out.println("\n=== Multiple Threads Demo ===");

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getId() + " started");
                ThreadOperations.sleepThread(1000);
                System.out.println("Thread " + Thread.currentThread().getId() + " completed");
            }
        };

        ThreadOperations.createAndStartMultipleThreads(3, task);
        ThreadOperations.sleepThread(2000);
    }
}