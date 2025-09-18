package oops.interfaceAbstractExercise;

// Abstract class
abstract class Shape {
    String color;

    // constructor
    Shape(String color) {
        this.color = color;
    }

    // concrete method
    void describe() {
        System.out.println("I am a " + color + " shape");
    }

    // abstract method
    abstract double area();
}

// Subclass 1
class Circle extends Shape {
    double radius;

    Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

// Subclass 2
class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}




public class shapeDrawing {

    public static void main(String[] args) {
        Shape c = new Circle(5, "Red");
        Shape r = new Rectangle(4, 6, "Blue");

        c.describe();
        System.out.println("Area: " + c.area());

        r.describe();
        System.out.println("Area: " + r.area());
    }
}
