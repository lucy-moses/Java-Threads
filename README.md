
# Java Threads Demonstration Repository


A complete demonstration of Java Thread operations with synchronization examples.

## Repository Structure

```
ThreadDemo/
├── Main.java                 # Program entry point
├── ThreadOperations.java     # Core thread operations
├── BasicThreadDemo.java      # Thread extension demo
├── RunnableThreadDemo.java   # Runnable interface demo
├── MultipleThreadsDemo.java  # Concurrent threads demo
├── SynchronizationDemo.java  # Synchronization techniques
└── README.md                # This documentation
```

## Class Documentation

### 1. `ThreadOperations.java`

Core utility class containing all thread operations.

#### Methods:

| Method | Parameters | Description |
|--------|------------|-------------|
| `createBasicThread()` | None | Creates thread by extending `Thread` class |
| `createRunnableThread(Runnable task)` | `Runnable` task | Creates thread using `Runnable` interface |
| `startThread(Thread thread, boolean shouldJoin)` | `Thread` thread, `boolean` shouldJoin | Starts thread with optional join |
| `createAndStartMultipleThreads(int count, Runnable task)` | `int` count, `Runnable` task | Creates & starts multiple threads |
| `getThreadState(Thread thread)` | `Thread` thread | Returns thread state as String |
| `sleepThread(long millis)` | `long` milliseconds | Sleeps current thread |
| `synchronizedMethod(String threadName)` | `String` threadName | Synchronized method demo |
| `synchronizedBlock(Object lock, String threadName)` | `Object` lock, `String` threadName | Synchronized block demo |

#### Inner Class:
```java
ThreadSafeCounter {
    synchronized void increment()  // Thread-safe increment
    synchronized int getCount()   // Thread-safe getter
}
```

### 2. Demonstration Classes

#### `BasicThreadDemo.java`
- `demo()`: Shows thread creation by extending `Thread` class

#### `RunnableThreadDemo.java`
- `demo()`: Demonstrates `Runnable` interface implementation

#### `MultipleThreadsDemo.java`
- `demo()`: Manages 3 concurrent threads

#### `SynchronizationDemo.java`
- `demo()`: Shows:
  1. Synchronized methods
  2. Synchronized blocks
  3. Thread-safe counter

### Key Definitions

| Term | Definition |
|------|------------|
| **Thread** | Lightweight sub-process, smallest execution unit |
| **Runnable** | Functional interface for thread tasks |
| **Synchronization** | Controlling thread access to shared resources |
| **Monitor Lock** | Mechanism for synchronization (intrinsic lock) |
| **Thread States** | NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED |

## How to Run

1. Compile all classes:
```bash
javac *.java
```

2. Execute the program:
```bash
java Main
```

## Expected Output

```
Starting Thread Demonstration...

=== Basic Thread Demo ===
Thread state after creation: NEW
Basic thread running (extends Thread)
Thread state after completion: TERMINATED

=== Runnable Thread Demo ===
Runnable task executing
Runnable task completed

=== Multiple Threads Demo ===
Thread 1 started
Thread 2 started
Thread 3 started
Thread 1 completed
Thread 2 completed
Thread 3 completed

=== Synchronization Demo ===

--- Synchronized Method Demo ---
Thread-1 entered synchronized method
Thread-1 exiting synchronized method
Thread-2 entered synchronized method
...

--- Thread-Safe Counter Demo ---
Final counter value: 5000
```

## Best Practices Demonstrated

1. Separation of concerns (operations vs demonstrations)
2. Proper synchronization for thread safety
3. Resource management with `join()`
4. State checking and validation
5. Clean exception handling


