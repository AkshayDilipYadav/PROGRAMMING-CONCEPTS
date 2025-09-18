package Concurrency.Synchronous_vs_Asynchronous_Exercise;

import java.util.concurrent.CompletableFuture;

public class SyncVsAsyncExample {

    public static void doTask(int id){
        System.out.println("Task " + id + " started by " + Thread.currentThread().getName());

        try{Thread.sleep(2000);}
        catch(InterruptedException e){e.printStackTrace();}

        System.out.println("Task " + id + " finished by " + Thread.currentThread().getName());
    }

    public static void synchronousExample(){
        System.out.println("\n --- Synchronous Execution ---");
        long start = System.currentTimeMillis();

        for(int i = 1; i <= 3; i++){doTask(i);}

        long end = System.currentTimeMillis();
        System.out.println("Synchronous total time: " + (end - start) + " ms");

    }


    public static void asynchronousExample() throws InterruptedException{
        System.out.println("\n --- Asynchronous Execution ---");
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> doTask(1));
        Thread t2 = new Thread(() -> doTask(2));
        Thread t3 = new Thread(() -> doTask(3));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end = System.currentTimeMillis();
        System.out.println("Aynchronous total time: " + (end - start) + " ms");

    }

    public static void completableFutureExample(){
        System.out.println("\n Asynchronous Execution (Completable Future ) \n");
        long start = System.currentTimeMillis();

        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> doTask(1));
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> doTask(2));
        CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> doTask(3));

        CompletableFuture.allOf(f1, f2, f3).join();
        long end = System.currentTimeMillis();

        System.out.println("Asynchronous Execution CompletableFuture : " + (end - start) + " ms");

    }

    public static void main(String[] args) throws InterruptedException{
        synchronousExample();

        asynchronousExample();

        completableFutureExample();
    }

}
