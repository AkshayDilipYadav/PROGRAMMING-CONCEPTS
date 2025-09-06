package methodOverloadingOverridingExercise;

public class Main {

    public static void main(String[] args){
        System.out.println("--- Method Overloading ---");
        calculator c = new calculator();
        System.out.println("Sum of 2 ints: " + c.add(5, 10));
        System.out.println("Sum of 2 doubts: " + c.add(5.5, 10.5));
        System.out.println("Sum of 3 ints: " + c.add(1,2,3));

        System.out.println("\n --- Method Overriding --- ");
        animal a1 = new animal();
        animal a2 = new dog(); // runtime polymorphism
        animal a3 = new cat(); // runtime polymorphism

        a1.sound();
        a2.sound();
        a3.sound();
    }
}
