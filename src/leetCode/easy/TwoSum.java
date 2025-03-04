package leetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int len = nums.length;

        // Brute Force solution
        // Time complexity O(n2)
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++) {
                if((nums[i] + nums[j]) == target) {
                    return new int[]{i,j};
                }
            }
        }


        // Better using HashMap
        // Time complexity : O(N)
        // Space complexity : O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i,};
            }
           map.put(nums[i], i);
        }
        return new int[]{};

        // using two pointer
        // Time complexity O(n log n) because we use sorting
        // Space complexity O(1)
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//
//        System.out.println("Array after sort : "+Arrays.toString(nums));
//
//        while (left != right) {
//            int sum = nums[left] + nums[right];
//
//            if (sum == target) {
//                return new int[]{left, right};
//            } else if (sum > target) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,9,11};
        int target = 10;
        int[] returnIndex = twoSum(arr, target);
        for (int index : returnIndex) {
            System.out.print(index + " ");
        }
    }
}
