package coreJava.multiThreading.runnable;

/**
 * We can not capture the thread reference at all so, it is useful for those scenario where you need fire and forget
 * types of thread. (ballistic threads)
 * No control over thread life cycle, fire and forget. run on background, doing their jobs silently.
 * Useful if we do not want to interact with the thread once they have started
 */
public class CountAndPrint implements Runnable {

    private final String name;

    public CountAndPrint(String name) {
        this.name = name;
    }

    /** This is what a CountAndPrint will do */
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(this.name + ": " + i);
        }
    }

    public static void main(String[] args) {
        // Launching 4 parallel threads
        for (int i = 1; i <= 4; i++) {
            // `start` method will call the `run` method
            // of CountAndPrint in another thread
            new Thread(new CountAndPrint("Instance " + i)).start();
        }
        // Doing some others tasks in the main Thread
        for (int i = 0; i < 10000; i++) {
            System.out.println("Main: " + i);
        }
    }
}
