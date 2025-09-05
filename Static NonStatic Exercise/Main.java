package StaticNonStaticExercise;

public class Main {

    public static void main(String[] args){
        Counter.showStaticCount(); // allowed without object

        Counter c1 = new Counter();
        c1.showInstanceCount();
        Counter.showStaticCount();

        Counter c2 = new Counter();
        c2.showInstanceCount();
        Counter.showStaticCount();

        Counter c3 = new Counter();
        c3.showInstanceCount();
        Counter.showStaticCount();


        // Show instance counts of different objects
        System.out.println("c1 instance count: " + c1.instanceCount); // 1
        System.out.println("c2 instance count: " + c2.instanceCount); // 1
        System.out.println("c3 instance count: " + c3.instanceCount); // 1

    }
}
