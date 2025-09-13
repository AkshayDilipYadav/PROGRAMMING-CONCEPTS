package exceptionHandling;

/*
An Error in Java is a subclass of Throwable that represents serious problems related to the Java runtime environment (JVM) that are usually outside the control of the application. Errors are not meant to be caught or handled by normal application code, since recovery is typically impossible.

Examples:

OutOfMemoryError (JVM runs out of heap space)

StackOverflowError (too deep recursion)

VirtualMachineError (serious JVM failure)

An Error is a serious JVM-level failure that applications should not attempt to handle.

*/

public class error {

    public static void main(String[] args){
        try{
            recursiveCall();
        }catch(StackOverflowError e){
            System.out.println("Caught Error (not recommended): " + e);
        }
    }

    static void recursiveCall(){recursiveCall();}
}
