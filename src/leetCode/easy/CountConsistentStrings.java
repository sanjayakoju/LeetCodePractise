package leetCode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1684. Count the Number of Consistent Strings
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 *
 *
 *
 * Example 1:
 *
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 * Example 2:
 *
 * Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * Output: 7
 * Explanation: All strings are consistent.
 * Example 3:
 *
 * Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * Output: 4
 * Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * The characters in allowed are distinct.
 * words[i] and allowed contain only lowercase English letters.
 */
public class CountConsistentStrings {

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        // Add each character in the 'allowed' string to the set
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int res = words.length;

        for (String st : words) {
            for (char c : st.toCharArray()) {
                if (!set.contains(c)) {
                    res -= 1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"}));
    }
}
