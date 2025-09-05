package ConstructorsExercise;

class Vehicle{
    String type;
    final int wheels; // final field must be initialized in every constructor

    Vehicle(){
        this.type = "Generic Vehicle";
        this.wheels = 4;
        System.out.println("Vehicle no-arg constructor called ");
    }

    //Parameterized constructor
    Vehicle(String type, int wheels){
        this.type = type;
        this.wheels = wheels;
        System.out.println("Vehicle constructor called: " + type + " Wheels: "+ wheels) ;
    }
}

class Car extends Vehicle{
    String brand;
    int year;

    //1. Default Constructor
    Car(){
        this("Unknown", 0);
        System.out.println("Car default constructor called");
    }

    // 2. Overloaded constructor (brand only)
    Car(String brand){
        this(brand, 0);
        System.out.println("Car constructor with brand only called");
    }

    // 3. Parameterized constructor

    Car(String brand, int year){
        super("Car", 4);
        this.brand = brand;
        this.year = year;
        System.out.println("Car parameterized constructor called");
    }

    // Method to show details
    void showDetails(){
        System.out.println("Brand : "+ brand+ " Year: " + year+ " Type: " + type + " Wheels " + wheels);
    }
}

// Grandchild class (Multi-level Inheritance)

class ElectricCar extends Car{
    int batteryCapacity;

    ElectricCar(String brand, int year, int batteryCapacity){
        super(brand, year);
        this.batteryCapacity = batteryCapacity;
        System.out.println("ElectricCar constructor called");
    }

    void showDetails(){
        super.showDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " KWH ");
    }
}

public class Constructors{
    public static void main(String[] args){
        System.out.println("\n--- c1: Default Car ---");
        Car c1 = new Car();
        c1.showDetails();

        System.out.println("\n--- c2: Car with Brand only ---");
        Car c2 = new Car("Toyota");
        c2.showDetails();

        System.out.println("\n--- c3: Car with Brand + Year ---");
        Car c3 = new Car("Tesla", 2023);
        c3.showDetails();

        System.out.println("\n--- ec1: Electric Car ---");
        ElectricCar ec1 = new ElectricCar("Tesla", 2023, 100);
        ec1.showDetails();

    }
}