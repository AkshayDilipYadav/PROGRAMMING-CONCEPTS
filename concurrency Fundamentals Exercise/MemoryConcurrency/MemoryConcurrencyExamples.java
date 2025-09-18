package Concurrency.MemoryConcurrency;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MemoryConcurrencyExamples {

    // ===== Shared Memory vs Message Passing =====
    static class SharedMemoryDemo {
        private int counter = 0;

        public void runDemo() throws InterruptedException {
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) counter++;
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) counter++;
            });

            t1.start(); t2.start();
            t1.join(); t2.join();

            System.out.println("[SharedMemory] Final counter = " + counter);
        }
    }

    static class MessagePassingDemo {
        private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        public void runDemo() throws InterruptedException {
            Thread producer = new Thread(() -> {
                try {
                    queue.put("Hello from producer!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread consumer = new Thread(() -> {
                try {
                    String msg = queue.take();
                    System.out.println("[MessagePassing] Received: " + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            producer.start();
            consumer.start();
            producer.join();
            consumer.join();
        }
    }

    // ===== Volatile Variables & Visibility =====
    static class VolatileDemo {
        private volatile boolean running = true;

        public void runDemo() throws InterruptedException {
            Thread worker = new Thread(() -> {
                System.out.println("[VolatileDemo] Worker started...");
                while (running) {
                    // busy-wait
                }
                System.out.println("[VolatileDemo] Worker stopped!");
            });

            worker.start();
            Thread.sleep(1000);
            System.out.println("[VolatileDemo] Setting running=false");
            running = false;
            worker.join();
        }
    }

    // ===== Visibility Issue (No volatile) =====
    static class VisibilityIssueDemo {
        private boolean running = true; // no volatile!

        public void runDemo() throws InterruptedException {
            Thread worker = new Thread(() -> {
                System.out.println("[VisibilityIssue] Worker started...");
                while (running) {
                    // Without volatile, this loop may never stop
                }
                System.out.println("[VisibilityIssue] Worker stopped!");
            });

            worker.start();
            Thread.sleep(1000);
            System.out.println("[VisibilityIssue] Setting running=false");
            running = false;
            worker.join(2000); // may hang if visibility issue occurs
        }
    }

    // ===== False Sharing =====
    static class FalseSharingDemo {
        static class Data {
            public volatile long value = 0;
            // Uncomment padding to reduce false sharing
            // public long p1, p2, p3, p4, p5, p6, p7;
        }

        private static final int NUM_THREADS = 4;
        private static final int ITERATIONS = 1_000_000;
        private final Data[] data = new Data[NUM_THREADS];

        public FalseSharingDemo() {
            for (int i = 0; i < NUM_THREADS; i++) {
                data[i] = new Data();
            }
        }

        public void runDemo() throws InterruptedException {
            Thread[] threads = new Thread[NUM_THREADS];
            for (int i = 0; i < NUM_THREADS; i++) {
                final int idx = i;
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < ITERATIONS; j++) {
                        data[idx].value++;
                    }
                });
            }

            long start = System.nanoTime();
            for (Thread t : threads) t.start();
            for (Thread t : threads) t.join();
            long end = System.nanoTime();

            System.out.println("[FalseSharing] Time = " + (end - start) / 1_000_000 + " ms");
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) throws Exception {
        System.out.println("=== Memory & Concurrency Examples ===");

        new SharedMemoryDemo().runDemo();
        new MessagePassingDemo().runDemo();

        new VolatileDemo().runDemo();

        new VisibilityIssueDemo().runDemo();

        new FalseSharingDemo().runDemo();
    }
}
