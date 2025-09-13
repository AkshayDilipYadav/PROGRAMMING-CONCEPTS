package exceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
A checked exception is an exception type that is checked at compile time by the Java compiler. If a method might throw a checked exception, it must either:

Handle it using a try-catch block, or

Declare it in the method signature with the throws keyword.

Examples: IOException, SQLException, ClassNotFoundException.

A checked exception is a compile-time enforced exception that the programmer must handle or declare.
*/

public class checkedException {

    // Method declares it might throw IOException(checked exception)
    static void readFile(String fileName) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader(fileName));
        System.out.println(b.readLine());
        b.close();
    }

    public static void main(String[] args){
        try{ readFile("nonexistent.txt");}
        catch(IOException e){
            System.out.println("Caught Checked Exception: " + e);
        }
    }
}
