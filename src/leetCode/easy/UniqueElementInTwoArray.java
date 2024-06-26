package leetCode.easy;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class UniqueElementInTwoArray {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++) {
            for(int j = 0;j<nums2.length;j++) {
                if(nums1[i] == nums2[j])
                    set.add(nums1[i]);
            }
        }

        int arr[] = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        for(int k=0;k<list.size();k++) {
            arr[k] = list.get(k);
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,7};
        int arr2[] = {1,2,3,4};
        int unique[] = intersection(arr1,arr2);
        System.out.println(Arrays.toString(unique));
    }
}
