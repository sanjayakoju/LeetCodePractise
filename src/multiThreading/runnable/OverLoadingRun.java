package multiThreading.runnable;

public class OverLoadingRun implements Runnable {
    @Override
    public void run() {

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
    }
}
