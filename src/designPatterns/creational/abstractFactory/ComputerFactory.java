package designPatterns.creational.abstractFactory;

public class ComputerFactory {

    public static Computer getComputer(ComputerAbstractFactory factory) {

        return factory.createComputer();
    }
}
