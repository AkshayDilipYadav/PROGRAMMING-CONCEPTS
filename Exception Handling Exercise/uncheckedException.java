package exceptionHandling;

/*
An unchecked exception is an exception type that occurs at runtime and is not checked at compile time by the Java compiler. Methods are not required to declare or handle them using throws or try-catch.

They typically represent programming errors such as invalid logic or improper API use (e.g., dividing by zero, accessing null references).

Examples: NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, IllegalArgumentException.

An unchecked exception is a runtime error that the compiler does not force the programmer to handle.
*/

public class uncheckedException {

    public static void main(String[] args){
        try{ int x = 10/0;}
        catch(ArithmeticException e){
            System.out.println("Caught Unchecked Exception: " + e);
        }

        try{
            String s = null;
            System.out.println(s.length());
        }
        catch(NullPointerException e){
            System.out.println("Caught Unchecked Exception: " + e);
        }
    }
}
