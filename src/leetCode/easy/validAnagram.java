package leetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class validAnagram {
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

//        // Time complexity : O(n) , O (S + T)
//        // Space complexity : O (S + T)
//        Map<Character, Integer> map1 = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (map1.containsKey(s.charAt(i))) {
//                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
//            } else {
//                map1.put(s.charAt(i), 1);
//            }
//
//            if (map2.containsKey(t.charAt(i))) {
//                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
//            } else {
//                map2.put(t.charAt(i), 1);
//            }
//        }
//
//
//        for (Map.Entry<Character, Integer> e1 : map1.entrySet()) {
//            int a = (map2.get(e1.getKey()) != null) ? map2.get(e1.getKey()) : 0;
//
//            int b = e1.getValue();
//
//            if (a != b) {
//                return false;
//            }
//        }
//        return true;

        // Using sort
        // Time complexity : O(n log n)
        // Space complexity: O(n)
        char [] chS = s.toCharArray();
        char [] chT = t.toCharArray();

        Arrays.sort(chS);
        Arrays.sort(chT);

        return Arrays.equals(chS, chT);
    }

    public static void main(String[] args) {
        String st1 = "rat";
        String st2 = "cat";
        System.out.println(isAnagram(st1,st2));
    }
}
