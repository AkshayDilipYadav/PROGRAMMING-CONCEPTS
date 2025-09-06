package OOPSEXERCISE;


/*

Inheritance

One class (child/subclass) acquires properties and methods of another class (parent/superclass).

Achieved with extends keyword.

Industry benefit: Code reuse, extensibility.

 */

/*

Polymorphism

Ability of the same method to behave differently based on context.

Compile-time polymorphism → method overloading.

Runtime polymorphism → method overriding.

Industry benefit: Flexibility, scalability.

*/

class libraryBook extends item{
    private book b;

    public libraryBook(String id, book b){
        super(id);
        this.b = b;
    }

    // method overriding
    @Override
    public void displayInfo(){
        System.out.println("Library ID: " + getId() + " -> ");
        b.display();
    }
}

class magazine extends item{

    private String title;

    public magazine(String id, String title){
        super(id);
        this.title = title;
    }

    @Override
    public void displayInfo(){
        System.out.println("Library ID: "+ getId() + " -> Magazine: " + title);
    }

}