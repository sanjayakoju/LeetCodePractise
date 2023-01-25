package kforce;

public class ProductSum {

    public static void main(String[] args) {
        ProductSum main = new ProductSum();
        System.out.println(main.digitsManipulations(10));
    }

    public int digitsManipulations(int n) {
        int product = 1;
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n = n / 10;
        }

        return product - sum;
    }
}
