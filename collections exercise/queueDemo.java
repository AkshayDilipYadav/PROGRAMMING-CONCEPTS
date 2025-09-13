package collections;

import java.util.*;

public class queueDemo {

    public static void main(String[] args){
        Queue<String> q = new LinkedList<>();
        q.offer("Task 1");
        q.offer("Task 2");
        q.offer("Task 3");

        System.out.println("Queue: " + q);

        System.out.println("Poll: " + q.poll());
        System.out.println("After Poll: " + q);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println("PriorityQueue (natural order): " + pq);
        System.out.println("Poll (smallest first): " + pq.poll());
    }
}
