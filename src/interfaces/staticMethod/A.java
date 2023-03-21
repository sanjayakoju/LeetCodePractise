package interfaces.staticMethod;

/**
 * From Java 8, just like we can write default methods inside interfaces. We can also write static method inside then
 * to define any utility functionality.
 * Since static method do not belong to particular object, they are not available to the classes implementing the
 * interface and they have to be called by using the interface name preceding the method name
 */
public interface A {

    static void fun1() {
        System.out.println("Calling static method");
    }

    static void sayHello() {
        System.out.println("Hello From A");
    }
}
