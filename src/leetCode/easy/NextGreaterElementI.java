package leetCode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 * Solved
 * Easy
 * Topics
 * Companies
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * Example 2:
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * All integers in nums1 and nums2 are unique.
 * All the integers of nums1 also appear in nums2.
 *
 *
 * Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // int len1 = nums1.length;
        // int len2 = nums2.length;
        // int[] ans = new int[len1];

        // // Iterate through each element in nums1
        // for (int i = 0; i < len1; i++) {
        //     int current = nums1[i];
        //     boolean found = false;
        //     ans[i] = -1; // Default to -1 if no greater element is found

        //     // Search for the current element in nums2
        //     for (int j = 0; j < len2; j++) {
        //         if (nums2[j] == current) {
        //             found = true;
        //         }
        //         // Once found, look for the next greater element
        //         if (found && nums2[j] > current) {
        //             ans[i] = nums2[j];
        //             break;
        //         }
        //     }
        // }

        // Using Monotonic Stack
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--) {
            if(stack.isEmpty()){
                stack.push(nums2[i]);
                map.put(nums2[i],-1);
            } else {
                while(!stack.isEmpty() && nums2[i]>=stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    map.put(nums2[i],-1);
                }else{
                    map.put(nums2[i],stack.peek());
                }
                stack.push(nums2[i]);
            }
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i]= map.get(nums1[i]);
        }
        return nums1;
    }
}
