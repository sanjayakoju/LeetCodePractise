package leetCode.easy;

import java.util.Stack;

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
