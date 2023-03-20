package interfaces.defaultDemo;

/**
 * Interface is call full dependency because all unimplemented method need to be implemented by the class
 * except static method. Because static belongs to the class/interface and stored in memory.
 */
public class MainDemo implements InterfaceA, InterfaceB {

    @Override
    public void sayHello() {
        InterfaceA.super.sayHello();
        InterfaceB.super.sayHello();
    }

    @Override
    public void sayHi() {
        System.out.println("from say Hi");
    }

    public static void main(String[] args) {
        MainDemo mainDemo = new MainDemo();
        mainDemo.sayHello();
        InterfaceB.sayBye();
        InterfaceA.sayBye();
    }
}
