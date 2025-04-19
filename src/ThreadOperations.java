/**
 * Core class containing all thread operations
 */
public class ThreadOperations {
    // Thread state constants
    public static final int NEW = 0;
    public static final int RUNNABLE = 1;
    public static final int BLOCKED = 2;
    public static final int WAITING = 3;
    public static final int TIMED_WAITING = 4;
    public static final int TERMINATED = 5;

    /**
     * Creates a basic thread by extending Thread class
     */
    public static Thread createBasicThread() {
        return new Thread() {
            @Override
            public void run() {
                System.out.println("Basic thread running (extends Thread)");
            }
        };
    }

    /**
     * Creates a thread using Runnable interface
     */
    public static Thread createRunnableThread(Runnable task) {
        return new Thread(task);
    }

    /**
     * Starts a thread with optional join
     */
    public static void startThread(Thread thread, boolean shouldJoin) {
        thread.start();
        if (shouldJoin) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread join interrupted: " + e.getMessage());
            }
        }
    }

    /**
     * Creates and starts multiple threads
     */
    public static void createAndStartMultipleThreads(int count, Runnable task) {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    /**
     * Gets the state of a thread as String
     */
    public static String getThreadState(Thread thread) {
        switch (thread.getState()) {
            case NEW: return "NEW";
            case RUNNABLE: return "RUNNABLE";
            case BLOCKED: return "BLOCKED";
            case WAITING: return "WAITING";
            case TIMED_WAITING: return "TIMED_WAITING";
            case TERMINATED: return "TERMINATED";
            default: return "UNKNOWN";
        }
    }

    /**
     * Puts current thread to sleep
     */
    public static void sleepThread(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }

    /**
     * Demonstrates synchronized method
     */
    public synchronized static void synchronizedMethod(String threadName) {
        System.out.println(threadName + " entered synchronized method");
        sleepThread(1000);
        System.out.println(threadName + " exiting synchronized method");
    }

    /**
     * Demonstrates synchronized block
     */
    public static void synchronizedBlock(Object lockObject, String threadName) {
        System.out.println(threadName + " approaching synchronized block");

        synchronized(lockObject) {
            System.out.println(threadName + " entered synchronized block");
            sleepThread(1000);
            System.out.println(threadName + " exiting synchronized block");
        }
    }

    /**
     * Thread-safe counter implementation
     */
    public static class ThreadSafeCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }
}