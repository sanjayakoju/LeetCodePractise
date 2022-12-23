package leetCode.medium;

import java.util.Stack;

/**
 * You have a string of zeros, ones and asterisks (*). Consider the following operations:
 * 1. Choose any two adjacent position in the string
 * 2. If one of them is 0 and the other is 1, remove two digits from the string
 *
 * Find the length of the smallest that can be obtained after applying this operation multiple times.
 *
 * Example
 * For s = "01010" the output should be
 * solution(s) = 1
 * For s = "111000" the output should be
 * solution(s) = 0
 * For s = "111*000" the output should be
 * solution(s) = 7
 */
public class SubSequence01 {

    static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '*') {
                stack.push(c);
            }

            if (c == '1') {
                if (!stack.isEmpty() && stack.peek() == '0') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (c == '0') {
                if (!stack.isEmpty() && stack.peek() == '1') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String str = "111000";
        System.out.println(solution(str));
    }
}
