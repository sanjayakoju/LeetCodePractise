package coreJava.multiThreading.synchronize;

/**
 * synchronized is used to lock a resource so only one thread can access it at a time, preventing thread interference and
 * memory consistency errors. Java supports synchronization at the method or block level.
 */
class Counter {
    private int count = 0;

    // Method-level synchronization: entire method is synchronized
    public synchronized void incrementMethodLevel() {
        count++;
    }

    // Block-level synchronization: only the block inside is synchronized
    public void incrementBlockLevel() {
        synchronized(this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Thread using method-level synchronization
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementMethodLevel();
            }
        });

        // Thread using block-level synchronization
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementBlockLevel();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print the final count (should be 2000 if synchronized correctly)
        System.out.println("Final count: " + counter.getCount());
    }
}

