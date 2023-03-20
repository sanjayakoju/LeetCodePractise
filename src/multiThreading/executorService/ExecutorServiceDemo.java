package multiThreading.executorService;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<List<Integer>> future = executorService.submit(new ComplexTask());
        List<Integer> list = future.get();
        System.out.println("Start : "+new Date());
        System.out.println(list.toString());
        System.out.println("End : "+new Date());
    }
}
