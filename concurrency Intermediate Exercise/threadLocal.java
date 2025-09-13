package concurrencyIntermediate;

public class threadLocal {


    private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int val = threadLocalValue.get();
            threadLocalValue.set(val + 1);
            System.out.println(Thread.currentThread().getName() + " → " + threadLocalValue.get());
        };

        new Thread(task, "Thread-A").start();
        new Thread(task, "Thread-B").start();
        new Thread(task, "Thread-C").start();
    }


}
