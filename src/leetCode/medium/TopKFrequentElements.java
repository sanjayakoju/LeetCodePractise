package leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * leetcode 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
//            map.merge(i, 1, Integer::sum);//For Getting Frequency OR
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a)); //Sort by Frequency in descending order

        //Using Heap Max
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
//            // If frequencies are the same, compare elements (larger element first)
//            if (b[1] == a[1]) {
//                return b[0] - a[0];
//            }
//            // Otherwise, compare by frequency (higher frequency first)
//            return b[1] - a[1];
//        });

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Step 3: Add all elements from the frequency map to the heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
//            res[i] = list.get(i);
            res[i] = maxHeap.poll()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2,2,3};
        int[]ans = topKFrequent(arr, 2);
        System.out.println(Arrays.toString(ans));
    }
}
