package leetCode.easy;

/**
 * Leetcode : 485. Max Consecutive Ones
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxSum = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else if (num == 1) {
                count++;
                maxSum = Math.max(count, maxSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

}
