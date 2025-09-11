package ConcurrencyExercise;

public class ConcurrencyExample {

    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> doWork("Task 1"));
        Thread t2= new Thread(() -> doWork("Task 2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms ");
    }

    private static void doWork(String taskName){
        System.out.println(taskName + " started" );
        try{Thread.sleep(2000);}
        catch(InterruptedException e){e.printStackTrace();}
        System.out.println(taskName + " completed");
    }
}
