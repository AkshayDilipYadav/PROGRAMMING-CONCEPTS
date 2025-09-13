package concurrencyFundamentals;


class SyncExample {
    public synchronized void methodLock() {
        System.out.println(Thread.currentThread().getName() + " → method lock");
    }

    public void blockLock() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " → block lock");
        }
    }

    public static synchronized void classLock() {
        System.out.println(Thread.currentThread().getName() + " → class-level lock");
    }
}



public class synchronizedDemo {

    public static void main(String[] args) {
        SyncExample obj = new SyncExample();

        new Thread(obj::methodLock, "T1").start();
        new Thread(obj::blockLock, "T2").start();
        new Thread(SyncExample::classLock, "T3").start();
    }

}
