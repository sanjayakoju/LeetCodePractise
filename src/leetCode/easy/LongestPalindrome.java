package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if(map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i]) + 1);
            } else {
                map.put(ch[i],1);
            }
        }

        int count = 0;
        boolean containOdd = false;
        for(Map.Entry<Character,Integer> e: map.entrySet()) {
            if(e.getValue()%2==0) {
                count = count + e.getValue();
            } else if (e.getValue() > 2) {
                count = count + (e.getValue() - 1);
                containOdd = true;
            } else if (e.getValue() == 1) {
                containOdd = true;
            }
        }

        if (containOdd) {
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
    }
}
