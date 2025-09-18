package Concurrency.High_Level_Concurrency;



import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class highLevelConcurrencyExamples {

    // ===== Thread Pool with Executors =====
    static void threadPoolExample() throws InterruptedException {
        System.out.println("\n--- Thread Pool Example ---");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " running in " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }

    // ===== Futures =====
    static void futureExample() throws Exception {
        System.out.println("\n--- Future Example ---");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(500);
            return 42;
        });

        System.out.println("Doing other work...");
        Integer result = future.get(); // blocking wait
        System.out.println("Future result = " + result);

        executor.shutdown();
    }

    // ===== CompletableFuture (Promises) =====
    static void completableFutureExample() {
        System.out.println("\n--- CompletableFuture Example ---");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Computing 6 * 7...");
            return 6 * 7;
        });

        future.thenApply(result -> result + 1)
                .thenAccept(result -> System.out.println("Result = " + result));

        future.join(); // wait for completion
    }

    // ===== Async/Await Simulation =====
    static void asyncAwaitSimulation() {
        System.out.println("\n--- Async/Await Simulation (CompletableFuture) ---");

        CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {}
                    return "Hello";
                }).thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " World"))
                .thenAccept(System.out::println);

        task.join();
    }

    // ===== Fork/Join Framework =====
    static class SumTask extends RecursiveTask<Integer> {
        private final List<Integer> numbers;

        SumTask(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        protected Integer compute() {
            if (numbers.size() <= 2) {
                return numbers.stream().mapToInt(Integer::intValue).sum();
            }

            int mid = numbers.size() / 2;
            SumTask left = new SumTask(numbers.subList(0, mid));
            SumTask right = new SumTask(numbers.subList(mid, numbers.size()));

            left.fork();
            int rightResult = right.compute();
            int leftResult = left.join();

            return leftResult + rightResult;
        }
    }

    static void forkJoinExample() {
        System.out.println("\n--- Fork/Join Example ---");
        ForkJoinPool pool = new ForkJoinPool();

        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();
        SumTask task = new SumTask(numbers);

        int result = pool.invoke(task);
        System.out.println("Sum = " + result);
    }

    // ===== MAIN =====
    public static void main(String[] args) throws Exception {
        System.out.println("=== High-Level Concurrency Examples ===");

        threadPoolExample();
        futureExample();
        completableFutureExample();
        asyncAwaitSimulation();
        forkJoinExample();
    }
}
