package leetCode.medium;

/**
 * leetcode : 12. Integer to Roman
 * Medium
 * Topics
 * Companies
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
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * Example 2:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 */
public class IntegerToRoman {

//    public static String intToRoman(int num) {
//        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
//        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
//        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
//        String thos[] = {"","M","MM","MMM"};
//
//        return thos[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[(num % 10)/1];
//    }

    public static String intToRoman(int num) {
        // Define the mappings of integer values to Roman numeral strings
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Loop through each value and symbol pair
        for (int i = 0; i < values.length && num > 0; i++) {
            // Append the corresponding Roman numeral symbol while the value can be subtracted from num
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num = num - values[i];
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(621));
    }
}
