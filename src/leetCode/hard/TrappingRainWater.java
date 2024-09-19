package leetCode.hard;

import java.util.Map;

/**
 * 42. Trapping Rain Water
 * Solved
 * Hard
 * Topics
 * Companies
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {
    // Space complexity: O(1)
    public static int trap(int[] height) {
        int len = height.length - 1;
        if(len <= 0)
            return 0;

        int l = 0, r = len;
        int leftMax = 0, rightMax = 0;
        int total = 0;

        while (l <= r) {
            if(leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[l]);
                total += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                total += rightMax - height[r];
                r--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})); // output: 6
    }
}
