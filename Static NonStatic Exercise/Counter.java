package StaticNonStaticExercise;

public class Counter {
    static int staticCount = 0;

    int instanceCount = 0;

    public Counter(){
        staticCount++;
        instanceCount++;
    }

    // static count
    public static void showStaticCount(){
        System.out.println("Static Count: " + staticCount);
    }

    // non- static count
    public void showInstanceCount(){
        System.out.println("Instance Count: " + instanceCount);
    }

}
