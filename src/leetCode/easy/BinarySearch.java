package leetCode.easy;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
//        int mid = nums.length/2;
//        if (nums[mid] == target) {
//            return mid;
//        }
//
//        for (int i =0; i< nums.length;i++) {
//            if (nums[i] == target)
//                return i;
//        }
//        return -1;
        int l = 0;
        int h = nums.length-1;
        return rBinarySearch(l,h,nums,target);
    }

    public static int rBinarySearch(int l, int h, int[] nums, int target) {
        // Only one element
        if (l == h) {
            if (nums[l] == target)
                return l;
            else
                return -1;
        } else {
            int mid = 1+(l+h)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if(target > nums[mid]) {
                return rBinarySearch(mid + 1, h, nums, target);
            }
            if (target < nums[mid]) {
                return rBinarySearch(l, mid -  1, nums, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = {1,2,3,4,5,6,7};
        int arr[] = {-1,0,3,5,9,12};
        int target = 9;
//        int arr[] = {2,5};
//        int target = 0;
        System.out.println(search(arr,target));
    }

}
