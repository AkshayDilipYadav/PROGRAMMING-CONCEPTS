package concurrencyFundamentals;

class MyThread extends Thread {
    public void run() {
        System.out.println(getName() + " is RUNNING");
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }
}



public class threadLifeCycle {

    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        System.out.println("Before start: " + t.getState()); // NEW
        t.start();
        System.out.println("After start: " + t.getState());  // RUNNABLE
        Thread.sleep(200);
        System.out.println("While sleeping: " + t.getState()); // TIMED_WAITING
        t.join();
        System.out.println("After completion: " + t.getState()); // TERMINATED
    }


}
