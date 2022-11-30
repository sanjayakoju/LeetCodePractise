package leetCode.easy;

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
        char ch[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<ch.length;i++) {
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
                stack.push(ch[i]);
            } else if (ch[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "({})";
        System.out.println(isValid(s));
    }
}
