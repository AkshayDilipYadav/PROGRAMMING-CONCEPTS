package concurrencyIntermediate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executorFramework {


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " running task");

        pool.execute(task);  // no return
        pool.submit(task);   // returns Future

        pool.shutdown();
    }


}
