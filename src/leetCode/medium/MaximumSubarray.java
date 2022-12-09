package leetCode.medium;

/**
 * Given an integer array nums, find the
 * subarray
 *  which has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            localMax = max(nums[i], nums[i] + localMax);

            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }

    static int max(int a, int b) {
        return (a > b) ?  a : b;
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
