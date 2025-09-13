package concurrencyFundamentals;



class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() +
                " deposited " + amount + " → Balance = " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() +
                    " withdrew " + amount + " → Balance = " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds!");
        }
    }
}




public class miniProjectBankAccount {


    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable t1 = () -> account.deposit(200);
        Runnable t2 = () -> account.withdraw(300);
        Runnable t3 = () -> account.withdraw(500);

        new Thread(t1, "User1").start();
        new Thread(t2, "User2").start();
        new Thread(t3, "User3").start();
    }


}
