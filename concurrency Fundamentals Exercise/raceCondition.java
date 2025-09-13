package concurrencyFundamentals;

class Counter {
    int count = 0;
    void increment() { count++; } // Not atomic
}

public class raceCondition {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Expected = 2000, Actual = " + counter.count);
    }

}
