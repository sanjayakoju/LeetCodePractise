package leetCode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * <p>
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * <p>
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 */
public class CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        backTrack(n, k, comb, 0, results);
        return results;
    }

    private static void backTrack(int n, int k, LinkedList<Integer> comb, int nextStart, List<List<Integer>> results) {

        if (n == 0 && comb.size() == k) {
            results.add(new ArrayList<>(comb));
            return;
        } else if (n < 0 || comb.size() == k) {
            return;
        }

        for (int i = nextStart; i < 9; i++) {
            comb.add(i + 1);
            backTrack(n - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3, 9);
        System.out.println(result);
    }
}
