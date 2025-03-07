package leetCode.medium;

/**
 * Leet code : 55. Jump Game
 * Solved
 * Medium
 * Topics
 * Companies
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(i>j)
                return false;
            j=Math.max(j,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(canJump(new int[]{2,3,1,1,4,5})); // true
        System.out.println(canJump(new int[]{2,3,1,1,0,5})); // false
    }
}
