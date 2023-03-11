package designPatterns.creational.singleton.eagerInitialization;

/**
 * In eager initialization, the instance of the singleton class is created at the time of class loading.
 * The drawback to eager initialization is that the method is created even though the client application might
 * not be using it. Here is the implementation of the static initialization singleton class:
 *
 * If your singleton class is not using a lot of resources, this is the approach to use. But in most of the scenarios,
 * singleton classes are created for resources such as File System, Database connections, etc. We should avoid the
 * instantiation unless the client calls the getInstance method. Also, this method doesn’t provide any options for
 * exception handling.
 */
public class EagerInitialization {
    private static EagerInitialization instance = new EagerInitialization();
    private EagerInitialization() {}
    private static EagerInitialization getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EagerInitialization eagerInitialization1 = getInstance();
    }
}
