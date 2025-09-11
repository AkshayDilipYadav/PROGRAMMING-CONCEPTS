package ConcurrencyExercise;

public class SequentialExample {

    public static void main(String[] args){
        long start = System.currentTimeMillis();
        doWork("Task 1");
        doWork("Task 2");

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms ");
    }
    private static void doWork(String taskName){
        System.out.println(taskName + " started");

        try{ Thread.sleep(2000);}
        catch (InterruptedException e){e.printStackTrace();}

        System.out.println(taskName + " completed");
    }
}
