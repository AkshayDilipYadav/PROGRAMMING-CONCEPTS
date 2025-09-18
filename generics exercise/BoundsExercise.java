package generics;

import java.util.*;

// A simple class hierarchy
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Puppy extends Dog {
    @Override
    public void makeSound() {
        System.out.println("Yip!");
    }
}

public class BoundsExercise {

    // Upper Bounded Example: Read from producer
    public static void playWithAnimals(List<? extends Animal> animals) {
        System.out.println("Playing with animals...");
        for (Animal a : animals) {
            a.makeSound();  //  Safe to read
        }
        // animals.add(new Dog());  Compile error (can't add)
    }

    // Lower Bounded Example: Write into consumer
    public static void addDogs(List<? super Dog> dogs) {
        System.out.println("Adding dogs...");
        dogs.add(new Dog());   //  Safe
        dogs.add(new Puppy()); //  Safe (Puppy is a Dog)
        // dogs.add(new Animal());  Not allowed
    }

    public static void main(String[] args) {
        // Upper bound: Producer
        List<Dog> dogList = Arrays.asList(new Dog(), new Puppy());
        playWithAnimals(dogList); // Works with Dog (subclass of Animal)

        List<Puppy> puppyList = Arrays.asList(new Puppy(), new Puppy());
        playWithAnimals(puppyList); // Works with Puppy (subclass of Animal)

        // Lower bound: Consumer
        List<Animal> animalList = new ArrayList<>();
        addDogs(animalList); //  Can add Dog/Puppy to Animal list

        List<Object> objectList = new ArrayList<>();
        addDogs(objectList); //  Can add Dog/Puppy to Object list

        // Show results after adding
        System.out.println("Animals after adding dogs:");
        for (Object obj : animalList) {
            System.out.println(obj);
        }
    }
}
