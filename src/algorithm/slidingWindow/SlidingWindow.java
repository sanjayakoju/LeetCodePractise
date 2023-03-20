package algorithm.slidingWindow;

public class SlidingWindow {

    public static int getMaxSum(int [] n, int k) {
        int windowSum = 0, maxSum = 0;
        for (int i=0;i<k;i++) {
            windowSum = windowSum + n[i];
        }
        for (int end = k; end < n.length; end++) {
            windowSum = windowSum + n[end] - n[end-k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,1,5,2,0};
        int k = 3;
        int maxSum = getMaxSum(arr, k);
        System.out.println("Max Sum : "+maxSum);
    }
}
