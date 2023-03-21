package multiThreading.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ComplexTaskUsingCallable implements Callable {
    @Override
    public Object call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<10;i++) {
            list.add(i*10);
            Thread.sleep(1000);
        }
        return list;
    }
}
