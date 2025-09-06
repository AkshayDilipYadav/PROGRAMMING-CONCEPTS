package OOPSEXERCISE;

/*

Abstraction

Hiding implementation details and exposing only the essential features.

Achieved using abstract classes and interfaces in Java.

Industry benefit: Focus on “what” instead of “how”.

 */

public abstract class item {

    private String id;

    public item(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public abstract void displayInfo();
}
