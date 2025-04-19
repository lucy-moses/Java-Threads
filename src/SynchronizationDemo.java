/**
 * Demonstrates thread synchronization techniques
 */
public class SynchronizationDemo {
    private static final Object lockObject = new Object();

    public static void demo() {
        System.out.println("\n=== Synchronization Demo ===");

        // Synchronized method demo
        System.out.println("\n--- Synchronized Method Demo ---");
        for (int i = 1; i <= 3; i++) {
            final int threadNum = i;
            new Thread(() -> {
                ThreadOperations.synchronizedMethod("Thread-" + threadNum);
            }).start();
        }
        ThreadOperations.sleepThread(3500);

        // Synchronized block demo
        System.out.println("\n--- Synchronized Block Demo ---");
        for (int i = 1; i <= 3; i++) {
            final int threadNum = i;
            new Thread(() -> {
                ThreadOperations.synchronizedBlock(lockObject, "Thread-" + threadNum);
            }).start();
        }
        ThreadOperations.sleepThread(3500);

        // Thread-safe counter demo
        System.out.println("\n--- Thread-Safe Counter Demo ---");
        ThreadOperations.ThreadSafeCounter counter = new ThreadOperations.ThreadSafeCounter();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            }).start();
        }
        ThreadOperations.sleepThread(2000);
        System.out.println("Final counter value: " + counter.getCount());
    }
}