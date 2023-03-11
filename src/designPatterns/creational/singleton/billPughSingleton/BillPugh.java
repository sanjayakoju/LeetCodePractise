package designPatterns.creational.singleton.billPughSingleton;

/**
 * Prior to Java 5, the Java memory model had a lot of issues, and the previous approaches used to fail in certain
 * scenarios where too many threads tried to get the instance of the singleton class simultaneously. So Bill Pugh
 * came up with a different approach to create the singleton class using an inner static helper class.
 * Here is an example of the Bill Pugh Singleton implementation:
 *
 * Notice the private inner static class that contains the instance of the singleton class. When the singleton class
 * is loaded, SingletonHelper class is not loaded into memory and only when someone calls the getInstance() method,
 * this class gets loaded and creates the singleton class instance. This is the most widely used approach for the
 * singleton class as it doesn’t require synchronization.
 */
public class BillPugh {
    private BillPugh() {}
    private static class BillPughHelper{
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return BillPughHelper.INSTANCE;
    }

    public static void main(String[] args) {
        BillPugh billPugh = getInstance();
        System.out.println(billPugh);
    }
}
