package leetCode.medium;

public class ClosestPairSum {

    public static int[] findClosestPair(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int closestSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(k - sum) < Math.abs(k - closestSum)) {
                closestSum = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5, 8, 14, 17, 25, 40, 43};
        int k = 35;
        int[] result = findClosestPair(arr, k);
        System.out.println("The closest pair is: (" + result[0] + ", " +
                result[1] + ")");
    }
}
