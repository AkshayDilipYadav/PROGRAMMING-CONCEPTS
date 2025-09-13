package concurrencyAdvanced;

import java.util.concurrent.ConcurrentLinkedQueue;


public class nonBlockingAlgorithms {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.add("A");
        queue.add("B");

        System.out.println(queue.poll()); // A
        System.out.println(queue.poll()); // B
    }

}
