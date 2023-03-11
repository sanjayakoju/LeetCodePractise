package leetCode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * Easy
 * 8.2K
 * 1K
 * Companies
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        int val;
        Set<Integer> set = new HashSet<>();
        while(true) {
            val = 0;
            while(n>0) {
                int rem = n%10;
                val = val + rem * rem;
                n = n/10;
            }
            if(val == 1) {
                return true;
            } else if(set.contains(val)) {
                return false;
            }
            set.add(val);
            n = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("21 is is happy no: "+isHappy(21));
        System.out.println("19 is happy no: "+isHappy(19));
    }
}
