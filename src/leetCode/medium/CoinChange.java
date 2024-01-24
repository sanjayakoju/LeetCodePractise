package leetCode.medium;

import java.util.Arrays;

/**
 * Leetcode 322. Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1; // Set max to a value greater than any possible solution
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max); // Initialize dp array with a value representing an unreachable state
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,5};
        System.out.println(coinChange(arr, 11));
    }
}
