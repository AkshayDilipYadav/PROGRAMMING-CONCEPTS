package lambdas;

public class lambdaBasics {

    public static void main(String[] args){
        Runnable r1 = new Runnable() {

            public void run() {
                System.out.println("Running in old style ");
            }
        };

        Runnable r2 = () -> System.out.println("Running in Lambda! ");

        r1.run();
        r2.run();
    }
}
