package generics;

import java.util.*;

class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getAll() {
        return items;
    }
}


class User {
    int id;
    String name;
    User(int id, String name) { this.id = id; this.name = name; }
    public String toString() { return id + " - " + name; }
}

class Product {
    String name;
    double price;
    Product(String name, double price) { this.name = name; this.price = price; }
    public String toString() { return name + " ($" + price + ")"; }
}


public class miniProject {


    public static void main(String[] args) {
        Repository<User> userRepo = new Repository<>();
        userRepo.add(new User(1, "Alice"));
        userRepo.add(new User(2, "Bob"));
        System.out.println("Users: " + userRepo.getAll());

        Repository<Product> productRepo = new Repository<>();
        productRepo.add(new Product("Laptop", 1200));
        productRepo.add(new Product("Phone", 800));
        System.out.println("Products: " + productRepo.getAll());
    }

}
