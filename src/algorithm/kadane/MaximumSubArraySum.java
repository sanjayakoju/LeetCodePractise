package algorithm.kadane;

public class MaximumSubArraySum {


    // Kadane's Algorithm
    public static int  maxSum(int arr[]) {
        int sum = arr[0];
        int maxSum = arr[0];

        for (int i=1;i<arr.length;i++) {
            if (sum >=0) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr));
    }
}
