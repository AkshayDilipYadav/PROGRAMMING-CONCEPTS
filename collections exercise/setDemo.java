package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class setDemo {

    public static void main(String[] args){
        Set<String> h = new HashSet<>();
        h.add("Banana");
        h.add("Apple");
        h.add("Orange");
        h.add("Apple");

        System.out.println("Hashset: " + h);

        Set<String> l = new LinkedHashSet<>(); // maintains insertion order
        l.addAll(h);
        System.out.println("LinkedHashSet: " + l);

        Set<String> t = new TreeSet<>(); // sorted
        t.addAll(h);
        System.out.println("TreeSet (Sorted): " + t);
    }
}
