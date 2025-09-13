package concurrencyIntermediate;

import java.util.concurrent.locks.ReentrantLock;


public class locksDemo {


    private static final ReentrantLock lock = new ReentrantLock(true); // fair lock

    private static void task(String name) {
        try {
            lock.lock();
            System.out.println(name + " acquired lock");
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        } finally {
            System.out.println(name + " released lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable r = () -> task(Thread.currentThread().getName());

        new Thread(r, "T1").start();
        new Thread(r, "T2").start();
        new Thread(r, "T3").start();
    }


}
