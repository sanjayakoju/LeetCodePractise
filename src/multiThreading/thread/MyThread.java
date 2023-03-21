package multiThreading.thread;

/**
 * Thread have gain full control over thread life cycle.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
