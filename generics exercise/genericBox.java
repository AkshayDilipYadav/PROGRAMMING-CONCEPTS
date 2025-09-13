package generics;

class Box<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}

public class genericBox {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.set(42);
        System.out.println("Integer Box: " + intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics!");
        System.out.println("String Box: " + strBox.get());
    }
}
