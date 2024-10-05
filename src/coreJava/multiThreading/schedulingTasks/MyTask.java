package coreJava.multiThreading.schedulingTasks;

import coreJava.multiThreading.thread.MyThread;

import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.print(i + " ");
        }
    }

    @Override
    public long scheduledExecutionTime() {
        return super.scheduledExecutionTime();
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
