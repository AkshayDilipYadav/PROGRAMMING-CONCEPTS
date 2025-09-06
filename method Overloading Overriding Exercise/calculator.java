package methodOverloadingOverridingExercise;

public class calculator {

    //Method overloading with different parameter types
    public int add(int a, int b){
        return a + b;
    }

    public double add(double a, double b){
        return a+b;
    }

    // Method overloading with different number of parameters
    public int add(int a, int b, int c){
        return a + b + c;
    }
}
