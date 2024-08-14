package leetCode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 76
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 *
 * Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class MinimumWindowSubstring {

//    public static String minWindow(String s, String t) {
//        if (s == null || s.isEmpty() || t == null || t.isEmpty())
//            return "";
//
//        Map<Character, Integer> tMap = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
//        }
//
//        int required = tMap.size();
//
//        int left = 0, right = 0;
//        int formed = 0;
//        Map<Character, Integer> windowCounts = new HashMap<>();
//        int[] ans = {-1, 0, 0};
//
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
//
//            if (tMap.containsKey(c) && windowCounts.get(c).intValue() == tMap.get(c).intValue()) {
//                formed++;
//            }
//
//            while (left <= right && formed == required) {
//                c = s.charAt(left);
//
//                if (ans[0] == -1 || right - left + 1 < ans[0]) {
//                    ans[0] = right - left + 1;
//                    ans[1] = left;
//                    ans[2] = right;
//                }
//
//                windowCounts.put(c, windowCounts.get(c) - 1);
//                if (tMap.containsKey(c) && windowCounts.get(c) < tMap.get(c)) {
//                    formed--;
//                }
//
//                left++;
//            }
//
//            right++;
//        }
//
//        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//    }


    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        // Create a map to store the frequency of characters in t
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // Create a map to track the frequency of characters in the current window
        Map<Character, Integer> windowFreq = new HashMap<>();

        int required = targetFreq.size(); // Number of unique characters in t
        int left = 0, right = 0; // Pointers for the sliding window
        int formed = 0; // Number of unique characters formed in the window

        // Variables to track the minimum window substring
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;

        // Sliding window algorithm
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if the current character forms a required character in the window
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window by moving the left pointer
            while (left <= right && formed == required) {
                // Update the minimum window substring if a smaller window is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }

                // Remove the leftmost character from the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // Check if removing this character breaks the required condition
                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    formed--;
                }

                left++; // Move the left pointer to the right
            }

            right++; // Move the right pointer to the right
        }

        // Return the minimum window substring if found, otherwise return an empty string
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(MinimumWindowSubstring.minWindow(s, t));
    }
}
