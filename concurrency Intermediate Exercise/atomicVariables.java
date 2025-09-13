package concurrencyIntermediate;

import java.util.concurrent.atomic.AtomicInteger;


public class atomicVariables {

    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet(); // atomic
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count (expected 2000) = " + atomicCounter.get());
    }


}
