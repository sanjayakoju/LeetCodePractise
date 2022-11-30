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
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 3) {
            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                list.add(nums[2]);
                lists.add(list);

            } else {
                lists = helper(nums, lists);
            }
        } else {
            lists = helper(nums, lists);
        }
        return lists;
    }

    private static List<List<Integer>> helper(int[] nums, List<List<Integer>> lists) {
        Set<List<Integer>> uniqueList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {

                    if (i != j && i != k && j != k) {
                        if ((nums[i] + nums[j] + nums[k]) == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
                            uniqueList.add(sortedList);
                        }
                    }
                }
            }

        }
        List<List<Integer>> retuenList = new ArrayList<>(uniqueList);
        return retuenList;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(threeSum(arr));
    }
}
