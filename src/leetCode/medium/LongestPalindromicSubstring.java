package leetCode.medium;

/**
 * 5. Longest Palindromic Substring
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    // Time complexity: O(n^2)
    public String longestPalindrome(String s) {
        int strLen = s.length();

        if(strLen < 2)
            return s;

        int resLen = 0;
        String result = "";

        for(int i=0;i<strLen;i++) {
            // Odd length;
            int l = i, r = i;
            while (l >= 0 && r < strLen && s.charAt(l) == s.charAt(r)) {
                if((r-l+1) > resLen) {
                    result = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }

            // Even length
            l = i;
            r = i+1;
            while(l >= 0 && r < strLen && s.charAt(l) == s.charAt(r)) {
                if((r-l+1) > resLen) {
                    result = s.substring(l,r+1);
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }
        return result;
    }
}
