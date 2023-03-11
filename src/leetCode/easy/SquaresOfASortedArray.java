package leetCode.easy;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Easy
 * 7.5K
 * 187
 * Companies
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int beg = 0, end = n-1, i=n-1;
        // while(i>=0) {
        //     if(nums[beg] * nums[beg] > nums[end] * nums[end]) {
        //         result[i--] = nums[beg] * nums[beg];
        //         beg++;
        //     } else {
        //         result[i--] = nums[end] * nums[end];
        //         end--;
        //     }
        // }

        for(int j=0;j<n;j++) {
            if(nums[beg] * nums[beg] > nums[end] * nums[end]) {
                result[i--] = nums[beg] * nums[beg];
                beg++;
            } else {
                result[i--] = nums[end] * nums[end];
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
