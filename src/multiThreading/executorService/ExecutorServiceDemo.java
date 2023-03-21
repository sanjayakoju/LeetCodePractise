package multiThreading.executorService;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo implements Runnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Start : "+new Date());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        // Submit return the Future
        Future<List<Integer>> future = executorService.submit(new ComplexTaskUsingCallable());
        List<Integer> list = future.get();

        System.out.println(list.toString());
        System.out.println("End : "+new Date());

        System.out.println("Start : "+new Date());
        // Execute does not return any value
        executorService.execute(new ExecutorServiceDemo());
        System.out.println("End Runnable");
        executorService.shutdown();
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.print(i + " ");
        }
    }
}
