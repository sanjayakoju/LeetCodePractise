package leetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfaPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() ==0) return res;

        Map<Character,String> map = new HashMap<>();
        char [] ch = digits.toCharArray();
        for(int i=0;i<ch.length;i++) {
            if(ch[i] == '2') {
                map.put(ch[i], "abc");
            } else if(ch[i] == '3') {
                map.put(ch[i], "def");
            } else if(ch[i] == '4') {
                map.put(ch[i], "ghi");
            } else if(ch[i] == '5') {
                map.put(ch[i], "jkl");
            } else if(ch[i] == '6') {
                map.put(ch[i], "mno");
            } else if(ch[i] == '7') {
                map.put(ch[i], "pqrs");
            } else if(ch[i] == '8') {
                map.put(ch[i], "tuv");
            } else if(ch[i] == '9') {
                map.put(ch[i], "wxyz");
            }
        }

        dfs(0, digits, new StringBuilder(), res, map);
        return res;
    }

    private static void dfs(int st, String digits, StringBuilder sb, List<String> res, Map<Character, String> map) {
        if(st == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(st));

        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(st + 1, digits, sb, res, map);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list.toString());
    }
}
