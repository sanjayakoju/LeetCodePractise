package leetCode.medium;

import java.util.Arrays;

/**
 * Leet code : 189. Rotate Array
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class RotateArray {

    public static int [] rotate(int [] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle case where K is greater than the array length;

//        int [] rotateArr = new int[n];
//        for (int i=0;i<n;i++) {
//            int newPosition = (i+k) % n;
//            rotateArr[newPosition] = nums[i];
//        }
//        return rotateArr;

        // for (int i = 0; i < k; i++) {
        //     int temp = nums[n - 1];

        //     // Shift elements to the right
        //     for (int j = n - 1; j > 0; j--) {
        //         nums[j] = nums[j - 1];
        //     }

        //     nums[0] = temp;
        // }

        int num[] = new int[n];

        for(int i=0;i<n;i++)
        {
            num[(i+k)%n]=nums[i];
        }


        for(int i=0;i<n;i++)
        {
            nums[i]=num[i];

        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int [] rotateArrays = rotate(nums, 3); // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(rotateArrays));
    }
}
