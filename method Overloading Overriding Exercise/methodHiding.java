package methodOverloadingOveriding;

class Parent {
    static void staticMethod() {
        System.out.println("Parent static");
    }
    void instanceMethod() {
        System.out.println("Parent instance");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Child static");
    }
    @Override
    void instanceMethod() {
        System.out.println("Child instance");
    }
}

class Demo {
    public static void main(String[] args) {
       Parent p = new Child();

        p.staticMethod();   // Parent static (compile-time, hiding)
        p.instanceMethod(); // Child instance (runtime, overriding)
    }
}
