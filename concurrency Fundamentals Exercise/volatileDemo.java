package concurrencyFundamentals;

public class volatileDemo {

    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread writer = new Thread(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            flag = false;
            System.out.println("Writer updated flag = false");
        });

        Thread reader = new Thread(() -> {
            while (flag) { } // Busy wait
            System.out.println("Reader detected flag change!");
        });

        writer.start();
        reader.start();
        writer.join(); reader.join();
    }

}
