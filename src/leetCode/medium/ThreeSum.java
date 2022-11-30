package leetCode.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
         Set<List<Integer>> set = new HashSet<>();
        int l, r;
         for(int i =0; i<nums.length;i++) {
//             if(i > 0 && nums[i] == nums[i-1]) {
//                 continue;
//             }
//             int l, r;
             l = i+1;
             r = nums.length-1;
             while (l < r) {
                 if (nums[i] + nums[l] + nums[r] == 0) {
                     List<Integer> list = new ArrayList<>();
                     list.add(nums[i]);
                     list.add(nums[l]);
                     list.add(nums[r]);
                     set.add(list);
                     l++;
//                     while (l < r && nums[l] == nums[l-1]) {
//                         l++;
//                     }
                 } else if(nums[i] + nums[l] + nums[r] < 0) {
                     l++;
                 } else {
                     r--;
                 }
             }
         }
        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(threeSum(arr));
    }
}
