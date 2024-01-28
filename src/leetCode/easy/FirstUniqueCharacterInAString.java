package leetCode.easy;

/**
 * leetcode 387 . First Unique Character in a String
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        int nIndex = Integer.MAX_VALUE;
        for(char i='a'; i<='z'; i++){
            int index = s.indexOf(i);
            if(index != -1 && index == s.lastIndexOf(i)){
                nIndex = Math.min(nIndex, index);
            }
        }
        return (nIndex == Integer.MAX_VALUE) ? -1 : nIndex;

//        for(char ch : s.toCharArray()) {
//            if(s.indexOf(ch) == s.lastIndexOf(ch)) {
//                return s.indexOf(ch);
//            }
//        }
//        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
