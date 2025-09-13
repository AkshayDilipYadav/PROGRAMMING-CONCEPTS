package concurrencyIntermediate;


import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) wait();
        buffer.add(value);
        System.out.println("Produced " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) wait();
        int value = buffer.poll();
        System.out.println("Consumed " + value);
        notifyAll();
        return value;
    }
}



public class producerConsumer {

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Runnable producer = () -> {
            for (int i = 1; i <= 10; i++) {
                try { buffer.produce(i); Thread.sleep(200); }
                catch (InterruptedException ignored) {}
            }
        };

        Runnable consumer = () -> {
            for (int i = 1; i <= 10; i++) {
                try { buffer.consume(); Thread.sleep(300); }
                catch (InterruptedException ignored) {}
            }
        };

        new Thread(producer, "Producer").start();
        new Thread(consumer, "Consumer").start();
    }

}
