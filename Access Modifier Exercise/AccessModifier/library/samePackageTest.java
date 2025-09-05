package AccessModifier.library;

public class samePackageTest {
    public static void main(String[] args){
        book b= new book();

        System.out.println(b.publicVar);
        System.out.println(b.defaultVar);
        System.out.println(b.protectedVar);


    }
}
