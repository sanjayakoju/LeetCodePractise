package leetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxF = 0;
        for(int r =0; r < s.length();r++) {
            char a = s.charAt(r);
            map.put(a, map.getOrDefault(a, 0) + 1);
            maxF = Math.max(maxF, map.get(a));

            // If the window size minus the frequency of the most common character is greater than k, shrink the window
            if((r - l + 1) - maxF > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }
}
