package leetCode.easy;

/**
 * leetcode 121
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                int profit = price - min;
                max = Math.max(max, profit);
            }
        }

        // Using two pointer pointer
        int l = 0, r = 1; // Left is buying and right for selling
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                max = Math.max(max, profit);
            } else {
                l = r;
            }
            r = r + 1;
        }
        return max;

    }

    public static void main(String[] args) {
//        int arr[] = {7,6,4,3,1,2,9,0};
        int arr[] = {7,1,5,3,6,4};
//        int arr[] = {4,3,1};
        System.out.println(maxProfit(arr));

    }

}
