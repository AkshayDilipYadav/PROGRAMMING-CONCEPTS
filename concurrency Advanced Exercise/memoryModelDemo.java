package concurrencyAdvanced;

public class memoryModelDemo {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!flag) {}
            System.out.println("Flag detected as true");
        }).start();

        Thread.sleep(1000);
        flag = true; // change visible due to volatile
    }


}
