package leetCode.medium;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int mid = 0, left,right;
        Arrays.sort(nums);
        for (int i=1;i<nums.length-1;i++) {
            mid = nums[i];
            left = i-1;
            right = i+1;
            while(left>=0 && right<nums.length) {
                int sum = mid + nums[right]+nums[left];
                if(sum ==target)
                    return sum;
                min = Math.abs(min)>Math.abs(target-sum)?target-sum:min;
                if(sum>target)
                    left--;
                else if(sum<target)
                    right++;
            }
        }
        return target-min;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,-1,-4};
        System.out.println(threeSumClosest(arr,1));
    }
}
