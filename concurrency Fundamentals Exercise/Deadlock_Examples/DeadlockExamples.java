package Concurrency.Deadlock_Examples;



import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class DeadlockExamples {

    // ===== 1. Deadlock Example =====
    static class DeadlockDemo {
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void runDemo() throws InterruptedException {
            Thread t1 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Thread 1: Holding lock1...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread 1: Waiting for lock2...");
                    synchronized (lock2) {
                        System.out.println("Thread 1: Acquired lock2!");
                    }
                }
            });

            Thread t2 = new Thread(() -> {
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock2...");
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                    System.out.println("Thread 2: Waiting for lock1...");
                    synchronized (lock1) {
                        System.out.println("Thread 2: Acquired lock1!");
                    }
                }
            });

            t1.start(); t2.start();
            t1.join(500); t2.join(500);

            System.out.println("Deadlock likely occurred (threads stuck).");
        }
    }

    // ===== 2. Deadlock Prevention (Lock Ordering) =====
    static class DeadlockPrevention {
        private final Object lock1 = new Object();
        private final Object lock2 = new Object();

        public void runDemo() throws InterruptedException {
            Runnable task = () -> {
                Object first = lock1;
                Object second = lock2;

                // Impose order: always acquire lock1 before lock2
                synchronized (first) {
                    synchronized (second) {
                        System.out.println(Thread.currentThread().getName() + " acquired both locks safely.");
                    }
                }
            };

            Thread t1 = new Thread(task, "Thread-1");
            Thread t2 = new Thread(task, "Thread-2");

            t1.start(); t2.start();
            t1.join(); t2.join();
        }
    }

    // ===== 3. Livelock Example =====
    static class LivelockDemo {
        static class Worker {
            private volatile boolean active = true;
            public void work(Worker other) {
                while (active) {
                    if (other.active) {
                        System.out.println(Thread.currentThread().getName() + " yielding...");
                        try { Thread.sleep(100); } catch (InterruptedException e) {}
                        continue; // keeps yielding → no progress
                    }
                    System.out.println(Thread.currentThread().getName() + " working!");
                    break;
                }
            }
        }

        public void runDemo() throws InterruptedException {
            Worker w1 = new Worker();
            Worker w2 = new Worker();

            Thread t1 = new Thread(() -> w1.work(w2), "Worker-1");
            Thread t2 = new Thread(() -> w2.work(w1), "Worker-2");

            t1.start(); t2.start();
            t1.join(500); t2.join(500);

            System.out.println("Livelock occurred (both keep yielding).");
        }
    }

    // ===== 4. Starvation Example =====
    static class StarvationDemo {
        private final ReentrantLock lock = new ReentrantLock(true); // fair = true prevents starvation

        public void runDemo() throws InterruptedException {
            Runnable task = () -> {
                while (true) {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + " got lock");
                        try { Thread.sleep(100); } catch (InterruptedException e) {}
                    } finally {
                        lock.unlock();
                    }
                    break;
                }
            };

            Thread high = new Thread(task, "High-Priority");
            Thread low = new Thread(task, "Low-Priority");

            high.setPriority(Thread.MAX_PRIORITY);
            low.setPriority(Thread.MIN_PRIORITY);

            low.start(); high.start();
            low.join(); high.join();

            System.out.println("With unfair locks, low-priority could starve.");
        }
    }

    // ===== 5. Deadlock Avoidance (Banker’s Algorithm Simplified) =====
    static class BankersAlgorithm {
        private final int totalResources = 10;
        private int available = totalResources;

        public synchronized boolean requestResources(int request) {
            System.out.println("Requesting " + request + " (Available: " + available + ")");
            if (request <= available) {
                available -= request;
                System.out.println("Granted " + request + " (Remaining: " + available + ")");
                return true;
            } else {
                System.out.println("Denied " + request + " (Not enough resources)");
                return false;
            }
        }

        public synchronized void releaseResources(int release) {
            available += release;
            System.out.println("Released " + release + " (Available: " + available + ")");
        }

        public void runDemo() {
            requestResources(7); // OK
            requestResources(5); // Denied → avoids unsafe state
            releaseResources(7);
            requestResources(5); // OK now
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) throws Exception {
        System.out.println("=== Deadlocks, Livelocks, and Starvation ===");

        new DeadlockDemo().runDemo();
        new DeadlockPrevention().runDemo();
        new LivelockDemo().runDemo();
        new StarvationDemo().runDemo();
        new BankersAlgorithm().runDemo();
    }
}
