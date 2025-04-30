package leetCode.medium;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                int a  = heap.poll();
                System.out.println(a);
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        System.out.println("Result : " +findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
