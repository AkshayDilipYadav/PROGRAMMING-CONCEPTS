package streams;

import java.util.*;

public class streamBasics {

    public static void main(String[] args){
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");

        //Traditional way
        for(String name: names){
            if(name.startsWith("A")){
                System.out.println("starts with A: " + name);
            }
        }

        // Using Streams
        names.stream()
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);

    }
}
