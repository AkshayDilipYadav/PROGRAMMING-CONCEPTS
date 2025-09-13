package streams;

import java.util.*;

public class streamOperations {

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // filter even number
        numbers.stream()
                .filter(n -> n%2 == 0)
                .forEach(n -> System.out.println("Even: " + n));

        //Map: square numbers
        numbers.stream()
                .map(n -> n*n)
                .forEach(n -> System.out.println("Square: " + n));

        //sort
        numbers.stream()
                .sorted((a,b) -> b-a)
                .forEach(n -> System.out.println("Sorted Desc: " + n));

        //Reduce (sum all numbers)
        int sum = numbers.stream()
                .reduce(0, (a,b) -> a+b);
        System.out.println("Sum = " + sum);

    }
}
