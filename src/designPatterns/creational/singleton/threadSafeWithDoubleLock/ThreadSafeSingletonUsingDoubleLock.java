package designPatterns.creational.singleton.threadSafeWithDoubleLock;

/**
 * The preceding implementation (Thread Safe) works fine and provides thread-safety, but it reduces the performance because of the
 * cost associated with the synchronized method, although we need it only for the first few threads that might create
 * separate instances. To avoid this extra overhead every time, double-checked locking principle is used. In this
 * approach, the synchronized block is used inside the if condition with an additional check to ensure that only one
 * instance of a singleton class is created. The following code snippet provides the double-checked locking
 * implementation:
 */
public class ThreadSafeSingletonUsingDoubleLock {

    private static ThreadSafeSingletonUsingDoubleLock instance = null;
    private ThreadSafeSingletonUsingDoubleLock() {}
    public static ThreadSafeSingletonUsingDoubleLock getInstance() {
        if(instance==null) {
            synchronized (ThreadSafeSingletonUsingDoubleLock.class) {
                if(instance==null) {
                    instance = new ThreadSafeSingletonUsingDoubleLock();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeSingletonUsingDoubleLock threadSafeSingletonUsingDoubleLock = getInstance();
        System.out.println(threadSafeSingletonUsingDoubleLock);
    }
}
