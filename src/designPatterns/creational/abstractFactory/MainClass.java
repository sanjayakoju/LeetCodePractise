package designPatterns.creational.abstractFactory;

/**
 *  Abstract Factory design pattern is one of the Creational patterns. Abstract Factory pattern is almost similar
 *  to Factory Pattern except the fact that its more like factory of factories.
 */
public class MainClass {

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PCFactory("16", "512", "2.1 GHZ"));
        System.out.println(pc);

        Computer server = ComputerFactory.getComputer(new ServerFactory( "24", "1 TB", "1.3"));
        System.out.println(server);
    }
}
