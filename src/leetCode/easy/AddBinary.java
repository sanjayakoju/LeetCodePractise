package leetCode.easy;

import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
//        int n1 = Integer.parseInt(a, 2);
//        int n2 = Integer.parseInt(b, 2);
//        // int sum = n1 + n2;
//        // System.out.println(sum);
//        // String st = Integer.toBinaryString(sum);
//        // System.out.println(st);
//        // return st;
//        return Integer.toString(n1+n2,2);

        BigInteger x = new BigInteger(a,2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger sum = x.add(y);
        return x.add(y).toString(2);
    }

    public static void main(String[] args) {
        String a = "100";
        String b = "1";
        System.out.println(addBinary(a,b));
    }
}
