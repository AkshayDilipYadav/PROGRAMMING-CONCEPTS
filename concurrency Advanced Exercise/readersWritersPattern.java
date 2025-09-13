package concurrencyAdvanced;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class readersWritersPattern {

    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static int sharedData = 0;

    static void write(int value) {
        rwLock.writeLock().lock();
        try {
            sharedData = value;
            System.out.println("Wrote " + value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    static void read() {
        rwLock.readLock().lock();
        try {
            System.out.println("Read " + sharedData);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> write(42)).start();
        new Thread(readersWritersPattern::read).start();
    }

}
