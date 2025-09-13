package generics;

// T must be a Number or its subclass
class Calculator<T extends Number> {
    private T num1, num2;

    Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return num1.doubleValue() + num2.doubleValue();
    }
}


public class boundedTypeDemo {

    public static void main(String[] args) {
        Calculator<Integer> intCalc = new Calculator<>(10, 20);
        System.out.println("Integer Add: " + intCalc.add());

        Calculator<Double> doubleCalc = new Calculator<>(5.5, 2.5);
        System.out.println("Double Add: " + doubleCalc.add());

        // Calculator<String> stringCalc = new Calculator<>("A", "B"); // ERROR
    }
}
