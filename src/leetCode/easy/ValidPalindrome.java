package leetCode.easy;

import java.util.Arrays;


/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
//        s = s.replaceAll("[^a-zA-Z0-9]", "");
//        s = s.toLowerCase();
//        char[] ch = s.toCharArray();
//        for (int i = 0, j= ch.length-1; i < ch.length/2; i++,j--) {
//            if(ch[i] != ch[j]) {
//                return false;
//            }
//        }
//        System.out.println(Arrays.toString(ch));

        int left = 0;
        int right = s.length()-1;

        // Using space complexity : O(n)
//        StringBuilder sb = new StringBuilder();
//        for(char c: s.toCharArray()) {
//            if(Character.isLetterOrDigit(c)) {
//                sb.append(Character.toLowerCase(c));
//            }
//        }
//
//        System.out.println(sb);
//
//        while (left<=right){
//            if (sb.charAt(left) == sb.charAt(right)) {
//                left++;
//                right--;
//            } else {
//                return false;
//            }
//        }

        while (left <= right) {
            char start  = s.charAt(left);
            char end = s.charAt(right);

            if(!Character.isLetterOrDigit(start)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                right--;
                continue;
            }

            if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
//        String str = "0P";
        System.out.println(isPalindrome(str));
    }
}
