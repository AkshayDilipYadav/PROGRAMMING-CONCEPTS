package generics;

import java.util.*;


public class collectionsWithGenerics {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");

        for (String name : names) {
            System.out.println("Name: " + name.toUpperCase());
        }

        // Using Map with Generics
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");

        String student = studentMap.get(101); // safe
        System.out.println("Student ID 101: " + student);
    }

}
