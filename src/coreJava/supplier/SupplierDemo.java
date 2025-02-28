package coreJava.supplier;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * Supplier is a functional interface that takes no arguments and returns a result through its get() method. It’s useful for
 * deferred execution or lazy generation of values.
 */
public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<Double> random = () -> Math.random();

        System.out.println(random.get());

        LocalDateTime.now();

    }
}
