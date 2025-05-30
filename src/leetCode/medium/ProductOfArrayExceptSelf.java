package leetCode.medium;

import java.util.Arrays;

/**
 * Leetcode 238
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int prefix = 1;
        System.out.println("Prefix");
        for (int i=0;i<nums.length;i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
            System.out.print(prefix  +" ");
        }

        System.out.println("array : "+Arrays.toString(res));

        int postFix = 1;

        System.out.println("Post fix");
        for (int i = nums.length-1; i>=0; i--) {
            res[i] = res[i] * postFix;
            postFix = postFix * nums[i];
            System.out.print(postFix  +" ");
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }
}
