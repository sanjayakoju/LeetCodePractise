package leetCode.easy;

/**
 * 303. Range Sum Query - Immutable
 * Solved
 * Easy
 * Topics
 * Companies
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= left <= right < nums.length
 * At most 104 calls will be made to sumRange.
 */
public class RangeSumQueryImmutable {

    int [] nums;
    int [] prefixSum;
    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        prefixSum = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            prefixSum[i] = nums[i];
            if(i > 0) {
                prefixSum[i] += prefixSum[i-1];
            }
        }
    }

    // // Brute Force approach
    // public int sumRange(int left, int right) {
    //     int sum = 0;
    //     for(int i=left;i<=right;i++) {
    //         sum += nums[i];
    //     }
    //     return sum;
    // }

    // Prefix sum approach
    public int sumRange(int left, int right) {
        // Check left is greater than 0 or not to maintain array index out of bound
        return prefixSum[right] - (left > 0 ? prefixSum[left-1] : 0);
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(left,right);
     */
}
