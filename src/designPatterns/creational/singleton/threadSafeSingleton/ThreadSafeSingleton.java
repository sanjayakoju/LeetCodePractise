package designPatterns.creational.singleton.threadSafeSingleton;

/**
 * A simple way to create a thread-safe singleton class is to make the global access method synchronized so that
 * only one thread can execute this method at a time. Here is a general implementation of this approach:
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance = null;
    private ThreadSafeSingleton() {}
    public static synchronized ThreadSafeSingleton getInstance() {
        if(instance==null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingleton threadSafeSingleton = getInstance();
        System.out.println(threadSafeSingleton);
    }
}
