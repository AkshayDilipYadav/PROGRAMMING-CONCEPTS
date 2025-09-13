package lambdas;

interface Calculator{
    int operate(int a, int b);
}
public class functionalInterface {

    public static void main(String[] args){
        Calculator add = (a, b) -> a+b;
        Calculator multiply = (a,b) -> a*b;

        System.out.println("Sum: " + add.operate(5,3));
        System.out.println("Product: " + multiply.operate(5,3));
    }
}
