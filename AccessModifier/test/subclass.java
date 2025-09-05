package AccessModifier.test;

import AccessModifier.library.book;

class test extends book {

    public void testsubclass(){
        System.out.println(publicVar);
        System.out.println(protectedVar);
    }
}

public class subclass {

    public static void main(String[] args){
        test t = new test();
        t.testsubclass();
    }
}
