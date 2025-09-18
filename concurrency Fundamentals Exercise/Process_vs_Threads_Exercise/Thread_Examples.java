package Concurrency.Process_vs_Threads_Exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thread_Examples {

    public static void threadDemo()throws InterruptedException{
        System.out.println("threadDemo process id: " + ProcessHandle.current().pid());

        Thread w = new Thread(() -> System.out.println("Worker Thread"));
        w.start();
        w.join();
    }

    private static int counter = 0;
    public static synchronized void increment(){ counter++; }


    public static void threadMemoryDemo() throws InterruptedException{
        Thread t1 = new Thread(() -> {for (int i = 0; i < 1000; i++) increment();});
        Thread t2 = new Thread(() -> {for(int i = 0; i < 1000; i++) increment();});

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("counter value : " + counter );
            }

            public static void threadPoolDemo()throws InterruptedException{
                ExecutorService e = Executors.newFixedThreadPool(3);

                for(int i = 1; i <= 5; i++){
                    int taskId = i;
                    e.submit(() -> System.out.println("Task ID " + taskId + " thread name " + Thread.currentThread().getName()));
                }

                e.shutdown();
                e.awaitTermination(1, TimeUnit.MINUTES);
            }


    public static void threadCrashDemo() {
        Thread t = new Thread(() -> {
            throw new RuntimeException("[ThreadCrashDemo] Boom! Worker thread crashed.");
        });

        t.start();
        System.out.println("[ThreadCrashDemo] Main thread continues...");
    }


     public static void main(String[] args) throws Exception{
        threadDemo();
        threadMemoryDemo();
        threadPoolDemo();
         threadCrashDemo();
     }
}
