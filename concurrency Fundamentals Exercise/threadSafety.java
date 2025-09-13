package concurrencyFundamentals;


class SafeCounter {
    private int count = 0;
    public synchronized void increment() { count++; }
    public synchronized int getCount() { return count; }
}


public class threadSafety {

    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();

        Runnable task = () -> { for (int i = 0; i < 1000; i++) counter.increment(); };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Thread-safe result = " + counter.getCount());
    }


}
