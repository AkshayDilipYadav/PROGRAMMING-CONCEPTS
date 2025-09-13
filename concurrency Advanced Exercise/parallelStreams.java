package concurrencyAdvanced;

import java.util.stream.IntStream;


public class parallelStreams {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long sum = IntStream.rangeClosed(1, 1_000_000)
                .parallel()
                .sum();

        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum + ", Time = " + (end - start) + "ms");
    }

}
