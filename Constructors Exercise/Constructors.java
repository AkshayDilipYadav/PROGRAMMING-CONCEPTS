package ConstructorsExercise;

class Vehicle{
    String type;

    // Parent class constructor
    Vehicle(String type){
        this.type = type;
        System.out.println("Vehicle constructor called: " + type);
    }
}

class Car extends Vehicle{

    String brand;
    int year;

    // 1. Default Constructor
    Car(){
        this("Unknown", 0);
        System.out.println("Car default constructor called ");
    }

    //2. Parameterized constructor
    Car(String brand, int year){
        super("Car");
        this.brand = brand;
        this.year = year;
        System.out.println("Car parameterized constructor called ");
    }

    // Method to show setails
    void showDetails(){
        System.out.println("Brand: " + brand + " year: " + year + " Type " + type);
    }
}

public class Constructors {
    public static void main(String[] args){
        // Using default constructor
        System.out.println();
        System.out.println("c1");
        System.out.println();
        Car c1 = new Car();
        c1.showDetails();

        // Using parameterized constructor
        System.out.println();
        System.out.println("c2");
        System.out.println();
        Car c2 = new Car("Toyota", 2020);
        c2.showDetails();

        System.out.println();
        System.out.println("c3");
        System.out.println();
        Car c3 = new Car("Tesla", 2023);
        c3.showDetails();
    }
}
