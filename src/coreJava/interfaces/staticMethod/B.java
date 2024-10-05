package coreJava.interfaces.staticMethod;

/**
 * Since static method are allowed from Java 8, we can write a main method inside an interface and execute it as as
 * well.
 */
public interface B extends A {

    static void sayHello() {
        System.out.println("Hello From B");
    }
    public static void main(String[] args) {
        B.sayHello();
        A.sayHello();
    }
}
