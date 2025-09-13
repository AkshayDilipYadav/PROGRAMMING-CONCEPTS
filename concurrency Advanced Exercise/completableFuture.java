package concurrencyAdvanced;

import java.util.concurrent.*;


public class completableFuture {

    public static void main(String[] args) throws Exception {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combined = task1.thenCombine(task2, Integer::sum);

        System.out.println("Result = " + combined.get());

        CompletableFuture<Void> all = CompletableFuture.allOf(task1, task2, combined);
        all.thenRun(() -> System.out.println("All tasks finished"));
    }

}
