package leetCode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 633. Sum of Square Numbers
 * Solved
 * Medium
 * Topics
 * Companies
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 *
 *
 *
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= c <= 231 - 1
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<=Math.sqrt(c);i++) {
            int square = i * i;
            map.put(square, map.getOrDefault(square, 0) + 1);
            int require = c - square;
            if(map.containsKey(require)) {
                return true;
            }
        }
        return false;
    }
}
