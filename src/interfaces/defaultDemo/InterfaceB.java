package interfaces.defaultDemo;

public interface InterfaceB {
    default void sayHello(){
        System.out.println("Hello From B");
    }

    static void sayBye() {
        System.out.println("Bye from A");
    }
}
