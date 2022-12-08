package leetCode.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int mid = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > mid) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,2,3,2,2};
        System.out.println(majorityElement(arr));
    }
}
