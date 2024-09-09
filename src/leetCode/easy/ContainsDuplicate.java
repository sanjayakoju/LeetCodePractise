package leetCode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode 217
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * Time complexity: O(n)
 * Space complexity : depend upon approach
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        // Using HashMap
        // Time complexity : O(n)
        // Space complexity : O(n)
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : nums) {
            if (map.containsKey(j)) {
                return true;
            }
            map.put(j, 1);
        }

        // Using HashSet
        // Time complexity : O(n)
        // Space complexity : O(n)
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return  true;
            }
            set.add(num);
        }

        // Can be solve with the sorting
        // Time complexity : O(n log n)
        // Space complexity : O(1)
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
}
