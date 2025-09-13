package streams;

import java.util.*;

public class parallelStream {

    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 20; i++) numbers.add(i);

        //sequential stream
        long start1 = System.currentTimeMillis();
        numbers.stream()
                .map(n -> {
                    try{Thread.sleep(50);} catch(InterruptedException e){}
                    return n*n;
                })
                .forEach(n -> {});
        long end1 = System.currentTimeMillis();
        System.out.println("Sequential took: " + (end1 - start1) + "ms");

        // Parallel Stream
        long start2 = System.currentTimeMillis();
        numbers.parallelStream()
                .map(n -> {
                    try{Thread.sleep(50);} catch(InterruptedException e){}
                    return n*n;
                })
                .forEach(n -> {});
        long end2 = System.currentTimeMillis();
        System.out.println("Parallel took : " + (end2 - start2) + "ms");
    }
}
