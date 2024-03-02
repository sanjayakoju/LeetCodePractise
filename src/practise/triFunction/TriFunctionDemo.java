package practise.triFunction;

public class TriFunctionDemo {

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> multiplyThenAdd = (x, y, z) -> x * y + z;

        System.out.println(multiplyThenAdd.apply(10, 2, 5));
    }
}

