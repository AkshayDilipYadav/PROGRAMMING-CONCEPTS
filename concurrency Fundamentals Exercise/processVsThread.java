package concurrencyFundamentals;

public class processVsThread {

    public static void main(String[] args){
        System.out.println("Process = independent program with its own memory space. ");
        System.out.println("Thread = smaller unit inside a process, shares heap memory. ");

        Runnable t = () -> {
            System.out.println(Thread.currentThread().getName() + " is running inside the same process. ");
        };

        new Thread(t, "Thread - 1").start();
        new Thread(t, "Thread - 2").start();

    }
}
