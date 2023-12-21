package leetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
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
        int returnArr [] = new int[2];

        // Brute Force solution time complexity O(n2)
//        for(int i =0;i<nums.length-1;i++) {
//            for(int j=i+1;j<nums.length;j++) {
//                if((nums[i]+nums[j]) == target) {
//                    returnArr[0] = i;
//                    returnArr[1] = j;
//                    break;
//                }
//
//            }
//        }

        // Better using HashMap Time complexity O(N)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                returnArr[0] = map.get(diff);
                returnArr[1] = i;
                return returnArr;
            }
           map.put(nums[i], i);
        }
        return returnArr;

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
