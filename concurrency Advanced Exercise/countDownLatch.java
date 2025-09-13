package concurrencyAdvanced;

import java.util.concurrent.CountDownLatch;


public class countDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " finished work");
            latch.countDown();
        };

        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();

        latch.await();
        System.out.println("All workers finished, proceeding...");
    }


}
