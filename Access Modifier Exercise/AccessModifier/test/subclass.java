package AccessModifier.test;

import AccessModifier.library.book;

class subclasstest extends book {

public void testaccess(){

    System.out.println(publicVar);
    System.out.println(protectedVar);


}
}

public class subclass{

    public static void main(String[] args){
        subclasstest s = new subclasstest();
        s.testaccess();
    }
}