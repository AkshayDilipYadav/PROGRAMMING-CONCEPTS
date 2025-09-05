package AccessModifier.library;

 public class book {

    public String publicVar = "Public String";
    protected String protectedVar = "Protected String";
    String defaultVar = "Default String";
    private String privateVar = "Private String";

    public void showall(){
        System.out.println(publicVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
        System.out.println(privateVar);

    }
     public static void main(String[] args){
         book b = new book();
         b.showall();
     }

}



