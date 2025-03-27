package leetCode.medium;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * Solved
 * Medium
 * Topics
 * Companies
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 * Example 2:
 *
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 * Example 3:
 *
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 *
 * Constraints:
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        // int[] foundArr = new int[2];

        while(low < high) {
            int sum = numbers[low] + numbers[high];

            if(sum == target) {
                // foundArr[0] = low + 1;
                // foundArr[1] = high + 1;
                return new int[]{low+1, high+1};
            }

            if(sum > target) {
                high--;
            } else {
                low++;
            }
        }
        // return foundArr;
        return new int[] {-1,-1};
    }

    private static int[] twoSum1(int [] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum == target) {
                return new int[]{l+1, r+1};
            }

            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int num[] = {1,2,3,5,7,9,11};
        System.out.println(Arrays.toString(twoSum1(num, 9)));
    }
}
