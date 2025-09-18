package Concurrency.SynchronizationExamples;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


public class SynchronizationExamples {


    // ========= Race Condition Demo =========
    static class RaceConditionDemo {
        private int counter = 0;

        public void runDemo() throws InterruptedException {
            Thread t1 = new Thread(this::increment);
            Thread t2 = new Thread(this::increment);

            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("[RaceCondition] Final counter = " + counter);
        }

        private void increment() {
            for (int i = 0; i < 100000; i++) {
                counter++; // not synchronized -> race condition
            }
        }
    }

    // ========= Critical Section with synchronized =========
    static class CriticalSectionDemo {
        private int counter = 0;

        public synchronized void increment() {
            counter++;
        }

        public void runDemo() throws InterruptedException {
            Thread t1 = new Thread(this::doWork);
            Thread t2 = new Thread(this::doWork);

            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("[CriticalSection] Final counter = " + counter);
        }

        private void doWork() {
            for (int i = 0; i < 100000; i++) increment();
        }
    }

    // ========= Locks & Mutexes =========
    static class LockDemo {
        private int counter = 0;
        private final ReentrantLock lock = new ReentrantLock();

        public void runDemo() throws InterruptedException {
            Thread t1 = new Thread(this::doWork);
            Thread t2 = new Thread(this::doWork);

            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("[LockDemo] Final counter = " + counter);
        }

        private void doWork() {
            for (int i = 0; i < 100000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // ========= Semaphores =========
    static class SemaphoreDemo {
        private final Semaphore semaphore = new Semaphore(2); // counting semaphore (2 permits)

        public void runDemo() {
            for (int i = 1; i <= 5; i++) {
                int id = i;
                new Thread(() -> {
                    try {
                        System.out.println("Thread " + id + " waiting for permit...");
                        semaphore.acquire();
                        System.out.println("Thread " + id + " acquired permit!");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("Thread " + id + " releasing permit.");
                        semaphore.release();
                    }
                }).start();
            }
        }
    }

    // ========= Monitors & Condition Variables =========
    static class MonitorDemo {
        private boolean ready = false;

        public synchronized void waitForSignal() {
            while (!ready) {
                try {
                    System.out.println("Worker waiting...");
                    wait(); // condition variable
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Worker resumed!");
        }

        public synchronized void sendSignal() {
            ready = true;
            notifyAll(); // signal waiting threads
            System.out.println("Signal sent!");
        }

        public void runDemo() throws InterruptedException {
            Thread worker = new Thread(this::waitForSignal);
            worker.start();

            Thread.sleep(2000);
            sendSignal();
            worker.join();
        }
    }

    // ========= MAIN =========
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Synchronization Primitives Demo ===");

        new RaceConditionDemo().runDemo();
        new CriticalSectionDemo().runDemo();
        new LockDemo().runDemo();

        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        semaphoreDemo.runDemo();
        Thread.sleep(4000); // wait for semaphore demo to finish

        new MonitorDemo().runDemo();
    }

}
