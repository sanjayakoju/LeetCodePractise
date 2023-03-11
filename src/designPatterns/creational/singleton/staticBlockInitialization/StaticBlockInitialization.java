package designPatterns.creational.singleton.staticBlockInitialization;

/**
 * Static block initialization implementation is similar to eager initialization, except that instance of the class
 * is created in the static block that provides the option for exception handling.
 *
 * Both eager initialization and static block initialization create the instance even before it’s being used and that
 * is not the best practice to use.
 */
public class StaticBlockInitialization {
    private static StaticBlockInitialization instance = null;

    // static block initialization for exception handling
    static {
        try {
            instance = new StaticBlockInitialization();
        } catch (Exception ex) {
            throw new RuntimeException("Exception occurred in creating singleton instance!");
        }
    }

    public static StaticBlockInitialization getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        StaticBlockInitialization staticBlockInitialization = getInstance();
        System.out.println(staticBlockInitialization);
    }
}
