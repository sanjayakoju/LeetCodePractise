package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 13. Roman to Integer
 * Easy
 * Topics
 * Companies
 * Hint
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        // Create a map of Roman numerals to their integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        // Loop through each character in the Roman numeral string from front to back
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // If the current value is greater than the previous value, subtract twice the previous value
            // (since it was already added in the previous iteration) and add the current value
            if (i > 0 && currentValue > prevValue) {
                total += currentValue - 2 * prevValue;
            } else {
                // Otherwise, add the current value to the total
                total += currentValue;
            }

            // Update the previous value
            prevValue = currentValue;
        }

        return total;
    }

    // S = "DCXXI"
//    public static int romanToInt(String s) {
//        int val = 0;
//        int n = s.length();
//
//        for (int i = 0; i < n; i++) {
//            char currentChar = s.charAt(i);
//
//            if (i + 1 < n && getValue(s.charAt(i + 1)) > getValue(currentChar)) {
//                // subtract the val if next element is greater than current
//                val = val - getValue(currentChar);
//            } else {
//                val = val + getValue(currentChar);
//            }
//        }
//
//        return val;
//    }

    private static int getValue(char romanNumeral) {
        switch (romanNumeral) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }
}
