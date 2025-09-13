package lambdas;

import java.util.*;

public class lambdaCollections {

    public static void main(String[] args){
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");

        Collections.sort(names, new Comparator<String> () {
          public int compare(String a, String b){return a.compareTo(b);}
        });

        System.out.println("Old sort: "+ names);

        names.sort((a,b) -> a.compareTo(b));
        System.out.println("Lambda sort: " + names);

        names.forEach(n -> System.out.println("Hello " + n));
    }
}
