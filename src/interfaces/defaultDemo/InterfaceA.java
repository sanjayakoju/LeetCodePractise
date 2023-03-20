package interfaces.defaultDemo;

public interface InterfaceA {

    default void sayHello() {
        System.out.println("Hello From A");
    }

    static void sayBye() {
        System.out.println("Bye from A");
    }

    void sayHi();
}
