package concurrencyIntermediate;

public class deadlockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("T1: Holding lock1...");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                synchronized (lock2) {
                    System.out.println("T1: Holding lock1 & lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("T2: Holding lock2...");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                synchronized (lock1) {
                    System.out.println("T2: Holding lock2 & lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
