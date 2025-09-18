package generics;


import java.util.*;

// 1. Generic Class
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

// 2. Generic Method
class Utils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// 3. Bounded Generic
class Calculator<T extends Number> {
    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}

// 4. Wildcard Generic
class Printer {
    public void printList(List<?> list) { // unknown type
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public void printNumbers(List<? extends Number> list) { // upper bound
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        System.out.println("Sum = " + sum);
    }
}




public class allGenerics {

    public static void main(String[] args) {

        // Using Generic Class
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("Box contains: " + stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("Box contains: " + intBox.get());

        // Using Generic Method
        String[] names = {"Alice", "Bob", "Charlie"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.print("Names: ");
        Utils.printArray(names);

        System.out.print("Numbers: ");
        Utils.printArray(numbers);

        // Using Bounded Generic
        Calculator<Integer> intCalc = new Calculator<>();
        System.out.println("Sum of Integers: " + intCalc.add(10, 20));

        Calculator<Double> doubleCalc = new Calculator<>();
        System.out.println("Sum of Doubles: " + doubleCalc.add(3.5, 2.7));

        // Using Wildcard Generic
        Printer printer = new Printer();
        List<String> stringList = Arrays.asList("A", "B", "C");
        List<Integer> intList = Arrays.asList(10, 20, 30);

        System.out.print("Wildcard List<String>: ");
        printer.printList(stringList);

        System.out.print("Wildcard List<Integer>: ");
        printer.printList(intList);

        System.out.print("Sum of numbers: ");
        printer.printNumbers(intList);
    }
}
