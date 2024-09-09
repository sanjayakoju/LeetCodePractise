package algorithm.luhn;

public class Luhn {

    public static boolean isValidLuhn(String number) {
//        int n = number.length();
//        int total = 0;
//        boolean even = true;
//        // iterate from right to left, double every 'even' value
//        for (int i = n - 2; i >= 0; i--) {
//            int digit = number.charAt(i) - '0';
//            if (digit < 0 || digit > 9) {
//                // value may only contain digits
//                return false;
//            }
//            if (even) {
//                digit <<= 1; // double value
//            }
//            even = !even;
//            total += digit > 9 ? digit - 9 : digit;
//        }
//        int checksum = number.charAt(n - 1) - '0';
//        return (total + checksum) % 10 == 0;

        int nDigits = number.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {

            int d = number.charAt(i) - '0';

            if (isSecond == true) {
                d = d * 2;
//                System.out.println("Double : "+d);
            }


            // We add two digits to handle
            // cases that make two digits
            // after doubling
            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
            System.out.println("N Sum : "+nSum);
        }
        System.out.println("Sum : "+nSum);
        return (nSum % 10 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isValidLuhn("6011006068553107"));
    }
}
