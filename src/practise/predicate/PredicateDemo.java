package practise.predicate;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> lesserThan = i -> (i < 18);

        System.out.println(lesserThan.test(100));
    }
}
