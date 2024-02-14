package algorithm.bitmanipulation;

public class BitManipulation {

    public static void main(String[] args) {
        int n = 45;
        String b = decimalToBinary(n);
        System.out.println("Binary : "+b);
        System.out.println("Decimal : "+ binaryToDecimal(b));
    }

    private static int binaryToDecimal(String b) {
        int result = 0;
        int powof2 = 1;

        for (int i = b.length()-1; i>=0;i--) {
            if (b.charAt(i) == '1') {
                result = result + powof2;
            }
            powof2 = powof2 * 2;
        }

        return result;
    }

    private static String decimalToBinary(int n) {
        String b = "";
        while (n >= 1) {
            int x = n % 2;
            n = n/2;
            b = x + b;
        }
        return b;
    }
}
