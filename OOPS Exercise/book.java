package OOPSEXERCISE;

/*
Encapsulation

Wrapping data (variables) and methods (functions) into a single unit (class).

Provides control of access through getters and setters.

Industry benefit: Data security, modularity, maintainability.

 */


public class book {

    // Encapsulation: private variables
    private String title;
    private String author;
    private double price;

    public book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle(){return title;}

   public String getAuthor(){return author;}

   public double getPrice(){return price;}

   public void setTitle(String title){this.title = title;}

   public void setAuthor(String author){this.author = author;}

   public void setPrice(double price){this.price = price;}

   public void display(){System.out.println("Book - " + title + " by " + author + " Price - " + price);}

}

