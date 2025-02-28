package coreJava.predicate;

import java.util.function.Predicate;

/**
 * A Predicate is a functional interface introduced in Java 8. It represents a boolean-valued function (a condition) that
 * takes a single argument. It has a method test() that returns true or false. It is used in filtering and validation.
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> lesserThan = i -> (i < 18);

        System.out.println(lesserThan.test(100));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4)); // true

    }
}
