package practise.biFunction;

import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(10, 20));
    }
}
