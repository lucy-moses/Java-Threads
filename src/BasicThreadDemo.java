/**
 * Demonstrates basic thread by extending Thread class
 */
public class BasicThreadDemo {
    public static void demo() {
        System.out.println("\n=== Basic Thread Demo ===");

        Thread thread = ThreadOperations.createBasicThread();
        System.out.println("Thread state after creation: " +
                ThreadOperations.getThreadState(thread));

        ThreadOperations.startThread(thread, true);
        System.out.println("Thread state after completion: " +
                ThreadOperations.getThreadState(thread));
    }
}