package generics;

public class genericMethodDemo {

    // Generic method with type parameter <T>
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4};
        String[] strArr = {"A", "B", "C"};

        printArray(intArr);
        printArray(strArr);
    }

}
