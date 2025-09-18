package Concurrency.Concurrency_vs_Parallelism_Exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyVsParallelism {

    static class Task implements Runnable{
        private final int id;
        Task(int id){this.id = id;}

        @Override
        public void run(){
            System.out.println("TAsk " + id + " started by thread " + Thread.currentThread().getName());

            try{Thread.sleep(1000);}
            catch(InterruptedException e){e.printStackTrace();}

            System.out.println("Task " + id + " finished by thread " + Thread.currentThread().getName());

        }

    }

    public static void main(String[] args) throws InterruptedException{

        System.out.println("\n ---------  Concurrency (single core / interleaved) --------- \n");
        ExecutorService c = Executors.newSingleThreadExecutor();
        for(int i = 1; i <= 4; i++){c.submit(new Task(i));}
        c.shutdown();
        c.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\n---------  Parallelism (multiple cores) --------- \n");


        int availableCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Cores: " + availableCores);
        ExecutorService p = Executors.newFixedThreadPool(availableCores);

        for(int i = 1; i <= 4; i++){p.submit(new Task(i));}
        p.shutdown();
        p.awaitTermination(10, TimeUnit.SECONDS);

    }
}
