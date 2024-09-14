package leetCode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
// // Create a map to store the frequency of characters in t
//         Map<Character, Integer> targetFreq = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
//         }

//         // Create a map to track the frequency of characters in the current window
//         Map<Character, Integer> windowFreq = new HashMap<>();

//         int required = targetFreq.size(); // Number of unique characters in t
//         int left = 0, right = 0; // Pointers for the sliding window
//         int formed = 0; // Number of unique characters formed in the window

//         // Variables to track the minimum window substring
//         int minLen = Integer.MAX_VALUE;
//         int minLeft = 0, minRight = 0;

//         // Sliding window algorithm
//         while (right < s.length()) {
//             char c = s.charAt(right);
//             windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

//             // Check if the current character forms a required character in the window
//             if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue()) {
//                 formed++;
//             }

//             // Try to shrink the window by moving the left pointer
//             while (left <= right && formed == required) {
//                 // Update the minimum window substring if a smaller window is found
//                 if (right - left + 1 < minLen) {
//                     minLen = right - left + 1;
//                     minLeft = left;
//                     minRight = right;
//                 }

//                 // Remove the leftmost character from the window
//                 char leftChar = s.charAt(left);
//                 windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

//                 // Check if removing this character breaks the required condition
//                 if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < targetFreq.get(leftChar).intValue()) {
//                     formed--;
//                 }

//                 left++; // Move the left pointer to the right
//             }

//             right++; // Move the right pointer to the right
//         }

//         // Return the minimum window substring if found, otherwise return an empty string
//         return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);

        if (t.length() > s.length()) {
            return "";
        }

        // Count frequencies of characters in t
        Map<Character, Integer> mapT = new HashMap<>();
        for(char c: t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0)+1);
        }


        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int subStrStart = 0;
        int required = mapT.size();
        int matched = 0;

        // Sliding window to find the minimum substring
        for(int r = 0;r<s.length();r++) {
            char right = s.charAt(r);
            if(mapT.containsKey(right)) {
                mapT.put(right, mapT.get(right) - 1);
                if(mapT.get(right) == 0) {
                    matched++;
                }
            }

            // Try to shrink the window when all characters from t are matched
            while(matched == required) {

                // Update the minimum length of window
                int windowLen = r - l + 1;
                if(minLen > windowLen) {
                    minLen = windowLen;
                    subStrStart = l;
                }

                char deletedCharOfLeft = s.charAt(l++);
                if(mapT.containsKey(deletedCharOfLeft)) {
                    if(mapT.get(deletedCharOfLeft) == 0) {
                        matched--;
                    }
                    mapT.put(deletedCharOfLeft, mapT.get(deletedCharOfLeft) + 1);
                }

            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(subStrStart, subStrStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
