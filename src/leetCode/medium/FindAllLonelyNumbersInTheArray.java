package leetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: 2150. Find All Lonely Numbers in the Array
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an integer array nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.
 *
 * Return all lonely numbers in nums. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,6,5,8]
 * Output: [10,8]
 * Explanation:
 * - 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
 * - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.
 * - 5 is not a lonely number since 6 appears in nums and vice versa.
 * Hence, the lonely numbers in nums are [10, 8].
 * Note that [8, 10] may also be returned.
 * Example 2:
 *
 * Input: nums = [1,3,5,3]
 * Output: [1,5]
 * Explanation:
 * - 1 is a lonely number since it appears exactly once and 0 and 2 does not appear in nums.
 * - 5 is a lonely number since it appears exactly once and 4 and 6 does not appear in nums.
 * - 3 is not a lonely number since it appears twice.
 * Hence, the lonely numbers in nums are [1, 5].
 * Note that [5, 1] may also be returned.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 106
 */
public class FindAllLonelyNumbersInTheArray {

    public static List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
          map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {

            if ( !(map.get(i) > 1) && !map.containsKey(i-1) && !map.containsKey(i+1) ) {
                list.add(i);
            }

            // if ( (map.get(i) > 1) || map.containsKey(i-1) || map.containsKey(i+1) ) {
            //     continue;
            // } else {
            //     list.add(i);
            // }
        }
        return list;
    }

    static int singleLonelyNumber(int [] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                set.remove(num);
//            } else {
//                set.add(num);
//            }
//        }
//
//        for (int n: set) {
//            return n;
//        }
//        return -1;

        // using XOR bitwise operator (no space complexity)
        // Logic XOR 5 ^ 5 = 0 , 0 ^ 5 = 0
        // Example 0 ^ 5 ^ 4 ^ 3 ^ 3 ^ 4 = 5

        int result = 0;
        for (int n: nums) {
            result = result  ^ n;
        }
        return result;
    }

    public static void main(String[] args) {
//        int [] nums = {1,3,5,3};
        int [] nums = {10,6,5,8};
        System.out.println(findLonely(nums));

        // Single lonely integer
        // Contains odd number and have one lonely number
        int [] n = {10,6,9,10,9,6,5};
        System.out.println("Single Lonely Integer : "+singleLonelyNumber(n));
    }
}
