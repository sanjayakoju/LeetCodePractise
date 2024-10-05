package designPatterns.structural.adapter;

/**
 * Adapter pattern works as a bridge between two incompatible coreJava.interfaces. This type of design pattern comes under
 * structural pattern as this pattern combines the capability of two independent coreJava.interfaces.
 *
 * This pattern involves a single class which is responsible to join functionalities of independent or incompatible
 * coreJava.interfaces
 *
 * Eg: Consider a scenario in which there is an app that's developed in the US which returns the top speed of luxury
 * cars in miles per hour (MPH). Now we need to use the same app for our client in the UK that wants the same results
 * but in kilometers per hour (km/h).
 *
 * To deal with this problem, we'll create an adapter which will convert the values and give us the desired results:
 */
public class MainDemo {
    public static void main(String[] args) {
        Moveable bmw = new BMW();
        MoveableAdapter moveableAdaptor = new MoveableAdpaterImpl(bmw);
        System.out.println("Speed in KMPH : "+moveableAdaptor.getSpeed());
        System.out.println("Speed in MPH : "+bmw.getSpeed());
    }
}
