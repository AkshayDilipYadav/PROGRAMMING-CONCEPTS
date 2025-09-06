package OOPSEXERCISE;

public class Main {

    public static void main(String[] args){
        //Encapsulation
        book b1 = new book("Clean Code", "Robert C. Martin", 45.0);
        book b2 = new book("Effective Java", "Joshua Bloch", 55.0);

        // Inheritance + Abstraction + Polymorphism
        item libBook1 = new libraryBook("B101", b1);
        item libBook2 = new libraryBook("B102", b2);
        item magazine1 = new magazine("M201", "Java Monthly");

        item[] libraryItems = {libBook1, libBook2, magazine1};

        System.out.println("--- Library Inventory ---");
        for(item i: libraryItems){
            i.displayInfo();
        }

        b1.setPrice(40.0);
        System.out.println("\nAfter updating book price: ");
        b1.display();
    }
}
