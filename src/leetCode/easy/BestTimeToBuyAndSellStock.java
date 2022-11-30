package leetCode.easy;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i =0; i< prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i] - min;
                max = Math.max(max, profit);
            }
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
