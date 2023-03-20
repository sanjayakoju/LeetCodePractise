package designPatterns.structural.proxy;

/**
 * Proxy means ‘in place of’, representing’ or ‘in place of’ or ‘on behalf of’ are literal meanings of proxy and that
 * directly explains Proxy Design Pattern.
 * In proxy pattern, we create object having original object to interface its functionality to outer world.
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("sanjaya.jpeg");
        image.display();
        System.out.println("");

        image.display();
    }
}
