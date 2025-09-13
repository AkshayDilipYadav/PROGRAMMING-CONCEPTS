package concurrencyIntermediate;


import java.util.concurrent.*;


public class callableFuture {


    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;
        };

        Future<Integer> future = pool.submit(task);

        System.out.println("Task submitted, waiting for result...");
        Integer result = future.get(); // blocks until result is ready
        System.out.println("Result = " + result);

        pool.shutdown();
    }

}
