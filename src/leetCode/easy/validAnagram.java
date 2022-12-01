package leetCode.easy;

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
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        if (ch1.length != ch2.length) {
            return false;
        }
        for (int i = 0; i < ch1.length;i++) {
            if(map1.containsKey(ch1[i])) {
                map1.put(ch1[i], map1.get(ch1[i]) + 1);
            } else {
                map1.put(ch1[i], 1);
            }
        }

        for (int i = 0; i < ch2.length;i++) {
            if(map2.containsKey(ch2[i])) {
                map2.put(ch2[i], map2.get(ch2[i]) + 1);
            } else {
                map2.put(ch2[i], 1);
            }
        }
        boolean isContain = false;
        if (map1.size() != map2.size()) {
            return false;
        }
        for(Map.Entry<Character, Integer> e1: map1.entrySet()) {
            int a = (map2.get(e1.getKey()) != null) ? map2.get(e1.getKey()) : 0;
            int b = (e1.getValue() != null ) ? e1.getValue() : 0;

            if ( a == b) {
                isContain = true;
            } else {
                return false;
            }
        }
        return isContain;
    }

    public static void main(String[] args) {
        String st1 = "rat";
        String st2 = "cat";
        System.out.println(isAnagram(st1,st2));
    }
}
