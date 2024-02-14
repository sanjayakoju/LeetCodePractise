package assessment.amazon;

public class StockPriceMaxProfitableGroups {

    // This is not the fully correct solution, the program is not outputting correct value for the 4th input.
    public static int countMaximumProfitableGroups(int[] stockPrices) {
        int n = stockPrices.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int maxInSubarray = stockPrices[i];
            for (int j = i; j < n; j++) {
                maxInSubarray = Math.max(maxInSubarray, stockPrices[j]);
                if (stockPrices[i] == maxInSubarray || stockPrices[j] == maxInSubarray) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] stockPrices1 = {3, 1, 3, 5};
        int[] stockPrices2 = {2, 3, 2};
        int[] stockPrices3 = {1, 5, 2};
        int[] stockPrices4 = {4, 3, 1, 3, 5}; // Incorrect Output for this.

        System.out.println(countMaximumProfitableGroups(stockPrices1)); // Correct Output: 10
        System.out.println(countMaximumProfitableGroups(stockPrices2)); // Correct Output: 5
        System.out.println(countMaximumProfitableGroups(stockPrices3)); // Correct Output: 5
        System.out.println(countMaximumProfitableGroups(stockPrices4)); // Correct Output: 11
    }
}

