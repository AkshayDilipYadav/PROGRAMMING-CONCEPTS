package collections;

import java.util.*;

public class listDemo {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Apple");

        System.out.println("LIst: " + list);

        //Access by index
        System.out.println("First Element: " + list.get(0));

        for(String fruit: list){
            System.out.println("Fruit: " + fruit);
        }

        Collections.sort(list);
        System.out.println("Sorted List: " + list);
    }
}
