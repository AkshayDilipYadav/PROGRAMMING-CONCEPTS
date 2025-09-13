package exceptionHandling;

/*
The finally block in Java is a construct that follows a try (and optionally catch) block.
 It contains code that is guaranteed to execute, regardless of whether an exception was thrown or not.
 The only time finally might not run is if the JVM itself shuts down abruptly (e.g., System.exit(), power failure).

Typical uses:

Closing resources (files, sockets, DB connections)

Releasing locks

Cleanup tasks
 */

public class finallyDemo {

    public static void main(String[] args){
        try{int x = 10/0;}
        catch(ArithmeticException e){
            System.out.println("Caught exception: "+ e);
        }finally{
            System.out.println("Finally block always runs (clean up code here)");
        }

        try{int y = 10/2;
            System.out.println("Result: " + y);
        }
        finally{
            System.out.println("Finally runs even if no exception.");
        }
    }
}
