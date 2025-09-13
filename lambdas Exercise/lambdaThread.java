package lambdas;

public class lambdaThread {

    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running old style");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Thread running with Lambda! "));

        t1.start();
        t2.start();
    }
}
