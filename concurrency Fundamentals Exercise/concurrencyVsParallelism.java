package concurrencyFundamentals;

public class concurrencyVsParallelism {

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " → step " + i);
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start(); t2.start();

        System.out.println("Available processors (cores) = " +
                Runtime.getRuntime().availableProcessors());
    }

}
