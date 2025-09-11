package ConcurrencyExercise;

/*
A race condition is a situation in concurrent programming where the program’s output or behavior depends on the relative
 timing or interleaving of operations between multiple threads or processes,
 and because of that, the result becomes unpredictable or incorrect.
*/
public class RaceConditionExample {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(RaceConditionExample::increment);
        Thread t2 = new Thread(RaceConditionExample::increment);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final counter value: " + counter);
    }

    private static void increment(){
        for(int i = 0; i < 10000; i++){counter++;}
    }
}
