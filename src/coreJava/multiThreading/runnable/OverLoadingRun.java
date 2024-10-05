package coreJava.multiThreading.runnable;

/**
 * We can not capture the thread reference at all so, it is useful for those scenario where you need fire and forget
 * types of thread. (ballistic threads)
 * No control over thread life cycle, fire and forget. run on background, doing their jobs silently.
 * Useful if we do not want to interact with the thread once they have started
 *
 * Value are return from task not from thread
 */
public class OverLoadingRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Start");
    }

    public void run(int a) throws InterruptedException {
        for(int i=0;i<a;i++) {
            System.out.println("I = "+i);
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OverLoadingRun overLoadingRun = new OverLoadingRun();
        overLoadingRun.run(10);
        Thread thread = new Thread(overLoadingRun);
        thread.start();
    }
}
