package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    private  static void backtrack(int openN, int closeN, int n, List<String> res, StringBuilder stack) {
        if(openN == closeN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if(openN < n) {
            stack.append('(');
            backtrack(openN + 1, closeN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if(closeN < openN) {
            stack.append(')');
            backtrack(openN, closeN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }
}
