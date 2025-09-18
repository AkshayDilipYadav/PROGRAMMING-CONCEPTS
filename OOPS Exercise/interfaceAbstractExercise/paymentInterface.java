package oops.interfaceAbstractExercise;



// Interface
interface Payment {
    void pay(double amount);  // abstract by default
}

// Implementing classes
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}


public class paymentInterface {

    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new PayPalPayment();

        p1.pay(500); // Paid 500 using Credit Card
        p2.pay(1200); // Paid 1200 using PayPal
    }

}
