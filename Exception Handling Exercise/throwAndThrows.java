package exceptionHandling;

/*
The throw keyword is used to explicitly create and hand over an exception object to the JVM at runtime. It is followed by a single exception instance.
throw is used to actually throw a specific exception object during program execution.

The throws keyword is used in a method declaration to indicate that the method might throw one or more exceptions (checked or unchecked).
It tells the caller of the method that they must be prepared to handle or propagate these exceptions.
throws is used to declare exceptions a method can throw, so the caller knows about them.
 */

class MyCheckedException extends Exception{
    public MyCheckedException(String msg){super(msg);}
}

public class throwAndThrows {

    static void riskyMethod() throws MyCheckedException{
        throw new MyCheckedException("Something went wrong!");
    }

    public static void main(String[] args){
        try{riskyMethod(); }
        catch(MyCheckedException e){
            System.out.println("Handled custom checked exception: " + e.getMessage());
        }
    }
}
