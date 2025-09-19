package Concurrency.Concurrency_Patterns;




import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class ConcurrencyPatterns {

    // ===== 1. Producer–Consumer Problem =====
    static class ProducerConsumer {
        private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        public void runDemo() throws InterruptedException {
            Thread producer = new Thread(() -> {
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Producing " + i);
                        queue.put(i); // blocks if full
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) { }
            });

            Thread consumer = new Thread(() -> {
                try {
                    for (int i = 1; i <= 5; i++) {
                        int item = queue.take(); // blocks if empty
                        System.out.println("Consuming " + item);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) { }
            });

            producer.start();
            consumer.start();
            producer.join();
            consumer.join();
        }
    }

    // ===== 2. Readers–Writers Problem =====
    static class ReadersWriters {
        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private int data = 0;

        public void runDemo() throws InterruptedException {
            Runnable reader = () -> {
                lock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " reads " + data);
                } finally {
                    lock.readLock().unlock();
                }
            };

            Runnable writer = () -> {
                lock.writeLock().lock();
                try {
                    data++;
                    System.out.println(Thread.currentThread().getName() + " writes " + data);
                } finally {
                    lock.writeLock().unlock();
                }
            };

            Thread t1 = new Thread(reader, "Reader-1");
            Thread t2 = new Thread(writer, "Writer-1");
            Thread t3 = new Thread(reader, "Reader-2");

            t1.start(); t2.start(); t3.start();
            t1.join(); t2.join(); t3.join();
        }
    }

    // ===== 3. Dining Philosophers Problem =====
    static class DiningPhilosophers {
        private final Semaphore[] forks = new Semaphore[5];

        public DiningPhilosophers() {
            for (int i = 0; i < 5; i++) forks[i] = new Semaphore(1);
        }

        class Philosopher extends Thread {
            private final int id;

            Philosopher(int id) { this.id = id; }

            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("Philosopher " + id + " thinking...");
                        Thread.sleep(200);

                        forks[id].acquire();
                        forks[(id+1)%5].acquire();

                        System.out.println("Philosopher " + id + " eating...");
                        Thread.sleep(200);

                        forks[id].release();
                        forks[(id+1)%5].release();
                    }
                } catch (InterruptedException e) { }
            }
        }

        public void runDemo() throws InterruptedException {
            for (int i = 0; i < 5; i++) {
                new Philosopher(i).start();
            }
            Thread.sleep(2000); // run briefly then stop
        }
    }

    // ===== 4. Barrier Synchronization =====
    static class BarrierDemo {
        public void runDemo() throws InterruptedException {
            int parties = 3;
            CyclicBarrier barrier = new CyclicBarrier(parties, () ->
                    System.out.println("All threads reached barrier, proceeding..."));

            Runnable task = () -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " working...");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(Thread.currentThread().getName() + " waiting at barrier");
                    barrier.await();
                } catch (Exception e) { }
            };

            for (int i = 0; i < parties; i++) new Thread(task).start();
            Thread.sleep(2000);
        }
    }

    // ===== 5. Thread-safe Collections =====
    static class ThreadSafeCollections {
        public void runDemo() throws InterruptedException {
            ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

            Runnable writer = () -> map.put(Thread.currentThread().getName(), 1);
            Runnable reader = () -> System.out.println("Map keys: " + map.keySet());

            Thread t1 = new Thread(writer, "Writer-1");
            Thread t2 = new Thread(writer, "Writer-2");
            Thread t3 = new Thread(reader);

            t1.start(); t2.start(); t3.start();
            t1.join(); t2.join(); t3.join();
        }
    }

    // ===== 6. Immutable Objects =====
    static class ImmutablePoint {
        private final int x, y;
        public ImmutablePoint(int x, int y) { this.x = x; this.y = y; }
        public int getX() { return x; }
        public int getY() { return y; }
    }

    static class ImmutableDemo {
        public void runDemo() {
            ImmutablePoint p = new ImmutablePoint(1, 2);
            System.out.println("Immutable Point: (" + p.getX() + ", " + p.getY() + ")");
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) throws Exception {
        System.out.println("=== Concurrency Patterns ===");

        new ProducerConsumer().runDemo();
        new ReadersWriters().runDemo();
        new DiningPhilosophers().runDemo();
        new BarrierDemo().runDemo();
        new ThreadSafeCollections().runDemo();
        new ImmutableDemo().runDemo();
    }
}
