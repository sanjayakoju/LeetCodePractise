package coreJava.multiThreading.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock is a lock in the java.util.concurrent.locks package, providing a way to explicitly control synchronization,
 * with features like fairness and the ability to interrupt a thread waiting for a lock.
 * Provided in Java to provide synchronization with greater flexibility.
 */
public class MyLockDemo implements Runnable {
    int sum =0;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            lock.lock();
            sum = sum + i;
            lock.unlock();
            System.out.println("Sum 1 = "+sum);
        }

        for (int i=0;i<10;i++) {
            lock.lock();
            sum = sum + i;
            lock.unlock();
            System.out.println("Sum 2 = "+sum);
        }
    }

    public static void main(String[] args) {
        MyLockDemo myLockDemo = new MyLockDemo();
        Thread thread = new Thread(myLockDemo);
        thread.start();
    }
}
