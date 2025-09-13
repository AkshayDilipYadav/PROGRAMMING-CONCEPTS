package collections;


import java.util.*;

public class collectionsUtilityDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 3, 2, 4);

        System.out.println("Original: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max: " + max + ", Min: " + min);

        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);
    }
}
