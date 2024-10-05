package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either '(' , ')', or lowercase English letter.
 *
 * Asked In Walmart Interview Question
 */
public class MinimumRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        List<Character> list = new ArrayList<>();
        int count = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                count += 1;
                list.add(c);
            } else if (c == ')' && count > 0) {
                count -= 1;
                list.add(c);
            } else if (c != ')') {
                list.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1; i >= 0; i--) {
            if(list.get(i) == '(' && count > 0) {
                count -= 1;
            } else {
                sb.append(list.get(i));
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)")); // Output: "lee(t(c)o)de"
    }
}
