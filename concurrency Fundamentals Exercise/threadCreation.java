package concurrencyFundamentals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class threadCreation {

    static class MyThread extends Thread {
        public void run() { System.out.println("Extending Thread → " + getName()); }
    }

    static class MyRunnable implements Runnable {
        public void run() { System.out.println("Runnable → " + Thread.currentThread().getName()); }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunnable()).start();

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(() -> System.out.println("ExecutorService → " + Thread.currentThread().getName()));
        pool.shutdown();
    }

}
