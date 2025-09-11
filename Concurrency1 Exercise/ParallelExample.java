package ConcurrencyExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelExample {

    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();

        ExecutorService e = Executors.newFixedThreadPool(2);

        e.submit(() -> doWork("Task 1"));
        e.submit(() -> doWork("Task 2"));

        e.shutdown();
        e.awaitTermination(5, TimeUnit.SECONDS);

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms ");
    }

    public static void doWork(String t){
        System.out.println(t + " started on " + Thread.currentThread().getName());
        try{Thread.sleep(2000);}
        catch(InterruptedException e){e.printStackTrace();}
        System.out.println(t + " completed");
    }

}
