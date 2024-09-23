package leetCode.medium;

/**
 * 647. Palindromic Substrings
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len < 2)
            return len;

        int res = 0;
        for(int i=0;i<len;i++) {
            // Odd length
            int l = i, r = i;
            while(l>=0 && r<len && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            // Even length
            l = i;
            r = i + 1;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}
