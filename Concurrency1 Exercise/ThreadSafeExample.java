package ConcurrencyExercise;

/*
A thread-safe class or method is one that can be safely used by multiple threads
at the same time without causing race conditions, data corruption, or unpredictable behavior.
*/

public class ThreadSafeExample {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(ThreadSafeExample::increment);
        Thread t2 = new Thread(ThreadSafeExample::increment);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final counter Value: " + counter);
    }

    private synchronized static void increment(){
        for(int i = 0; i <  10000; i++){counter++;}
    }
}
