package concurrencyAdvanced;

public class realWorldIssues {

    static class Shared {
        volatile long value1;
        volatile long value2;
    }

    public static void main(String[] args) {
        Shared shared = new Shared();
        Runnable t1 = () -> { for (int i = 0; i < 1_000_000; i++) shared.value1++; };
        Runnable t2 = () -> { for (int i = 0; i < 1_000_000; i++) shared.value2++; };

        new Thread(t1).start();
        new Thread(t2).start();
    }
}
