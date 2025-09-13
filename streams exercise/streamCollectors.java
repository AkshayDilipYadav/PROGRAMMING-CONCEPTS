package streams;

import java.util.*;
import java.util.stream.Collectors;

public class streamCollectors {

    public static void main(String[] args){
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie", "Alice");

        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Uppercase: " + upper);

        Set<String> unique = names.stream()
                .collect(Collectors.toSet());
        System.out.println("Unique Names: " + unique);

        Map<String, Integer> nameLength = names.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> n.length(),
                        (v1, v2) -> v1
                ));

        System.out.println("Map of name -> length: " + nameLength);

        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + grouped);
    }
}
