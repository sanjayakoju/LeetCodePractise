package designPatterns.creational.factory;

/**
 * The factory design pattern is used when we have a superclass with multiple sub-classes and based on input,
 * we need to return one of the sub-class. This pattern takes out the responsibility of the instantiation of a class
 * from the client program to the factory class. Let’s first learn how to implement a factory design pattern in java
 * and then we will look into factory pattern advantages. We will see some of the factory design pattern usage in JDK.
 * Note that this pattern is also known as Factory Method Design Pattern.
 */
public class MainClass {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("pc", "12", "512", "Octa core");
        System.out.println(pc);

        Computer server = ComputerFactory.getComputer("server", "24", "1 TB", "Hexa core");
        System.out.println(server);
    }
}
