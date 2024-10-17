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
        int res = 0, count = 0;

        // for(int n: nums) {
        //     if(count == 0)
        //         res = n;
        //     count += (n == res? 1: -1);
        // }

        // return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if(map.get(n) > count) {
                res = n;
                count = map.get(n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,2,3,2,2};
        System.out.println(majorityElement(arr));
    }
}
