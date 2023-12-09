package assessment.kforce;

public class DigitsManipulations {

    private static int sum(int n) {
        int product = 1;
        int sum = 0;
        int rem = 0;
        while (n!=0) {
            rem = n % 10;
            product = product * rem;
            sum = sum + rem;
            n = n / 10;
        }
        return product -  sum;
    }

    public static void main(String[] args) {
//        int n = 123456;
        int n = 1010;
        System.out.println(sum(n));
    }
}
