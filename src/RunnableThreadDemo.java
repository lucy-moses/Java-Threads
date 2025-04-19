/**
 * Demonstrates thread creation using Runnable interface
 */
public class RunnableThreadDemo {
    public static void demo() {
        System.out.println("\n=== Runnable Thread Demo ===");

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable task executing");
                ThreadOperations.sleepThread(1500);
                System.out.println("Runnable task completed");
            }
        };

        Thread thread = ThreadOperations.createRunnableThread(task);
        ThreadOperations.startThread(thread, true);
    }
}
