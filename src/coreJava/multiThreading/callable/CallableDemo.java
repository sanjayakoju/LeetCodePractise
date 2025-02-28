package coreJava.multiThreading.callable;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable is similar to Runnable but can return a result and throw a checked exception.
 * It’s commonly used with ExecutorService to submit tasks that return a result.
 */
public class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;
        };
        Future<Integer> result = Executors.newSingleThreadExecutor().submit(task);
        result.get();

    }
}
