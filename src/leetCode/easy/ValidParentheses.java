package leetCode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
//        char[] ch = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for (char c : ch) {
//            if (c == '(' || c == '{' || c == '[') {
//                stack.push(c);
//            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
//                stack.pop();
//            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
//                stack.pop();
//            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
//                stack.pop();
//            } else {
//                return false;
//            }
//        }
//
//        return stack.isEmpty();


        //Solution with HashMap Lookup table as described in the video
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketLookup = new HashMap<>(3);

        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (bracketLookup.containsKey(c)) {
                if (!stack.isEmpty() && bracketLookup.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "({})";
        System.out.println(isValid(s));
    }
}
