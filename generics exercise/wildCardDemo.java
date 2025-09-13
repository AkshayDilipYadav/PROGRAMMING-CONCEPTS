package generics;

import java.util.*;


public class wildCardDemo {

    // Accepts List of any type
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // Upper bounded wildcard
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        List<String> strList = Arrays.asList("A", "B", "C");

        printList(intList);
        printList(doubleList);
        printList(strList);

        System.out.println("Sum of Integers: " + sumOfList(intList));
        System.out.println("Sum of Doubles: " + sumOfList(doubleList));
    }

}
