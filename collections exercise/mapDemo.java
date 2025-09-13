package collections;

import java.util.*;

public class mapDemo {

    public static void main(String[] args){
        Map<Integer, String> m = new HashMap<>();
        m.put(101, "John");
        m.put(102, "Alice");
        m.put(103, "Bob");
        m.put(104, "Charlie");

        System.out.println("HashMap: " + m);
        // Iteration
        for (Map.Entry<Integer, String> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // LinkedHashMap (insertion order)
        Map<Integer, String> linkedMap = new LinkedHashMap<>(m);
        System.out.println("LinkedHashMap: " + linkedMap);

        // TreeMap (sorted by keys)
        Map<Integer, String> treeMap = new TreeMap<>(m);
        System.out.println("TreeMap (sorted): " + treeMap);
    }
}
