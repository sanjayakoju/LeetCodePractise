package leetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        backTrack(nums, 0, new ArrayList<>(), result);

         result.add(new ArrayList<>());
         for(int num : nums) {
             int size = result.size();
             for(int i=0;i<size;i++) {
                 List<Integer> subset = new ArrayList<>(result.get(i));
                 subset.add(num);
                 result.add(subset);
             }
         }
        return result;
    }

    private void backTrack(int [] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int [] nums = {1,2,4};
        List<List<Integer>> result = subSets.subsets(nums);
        System.out.println(result);
    }
}
