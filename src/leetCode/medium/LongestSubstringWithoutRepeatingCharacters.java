package leetCode.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
//        int maxLength = -1;
//        StringBuilder test = new StringBuilder();
//
//        if(s.isEmpty())
//            return 0;
//        else if (s.length() == 1)
//            return 1;
//
//        for (char c : s.toCharArray()) {
//            String current = String.valueOf(c);
//
//            if (test.toString().contains(current)) {
//                test = new StringBuilder(test.substring(test.indexOf(current) + 1));
//            }
//            test.append(c);
//            maxLength = Math.max(test.length(), maxLength);
//        }
//
//
//        return maxLength;

        // Using sliding window
        Set<Character> set = new HashSet<>();
        int l = 0;
        int res = 0;
        for(int r = 0;r<s.length();r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;

    }

    public static void main(String[] args) {
//        String str = "pwwkew";
        String str = "ckilbkd";
//        String str = "dvdf";
//        String str = "aab";
        System.out.println(lengthOfLongestSubstring(str));

        // Bitwise
        int x = 3 & 5;
        int y = 3 | 5;
        System.out.println(x);
        System.out.println(y);

        PriorityQueue<String> toDo = new PriorityQueue<>();
        toDo.add("dishes");
        toDo.add("laundry");
        toDo.add("bills");
        toDo.offer("bills");
        System.out.println(toDo.size() + " " + toDo.poll());
        System.out.println(" " + toDo.peek() + " " + toDo.poll());
        System.out.println(" " + toDo.poll() + " " + toDo.poll());
    }
}
