package leetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 46. Permutations
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutation {

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static List<List<Integer>> getPermutation(int [] arr, int l, int r) {

//         List<List<Integer>> perms = new ArrayList<>();
//         perms.add(new ArrayList<>());
//
//         for(int n: arr) {
//             List<List<Integer>> nextPerms = new ArrayList<>();
//
//             for(List<Integer> p: perms) {
//                 for(int i=0;i<p.size() + 1;i++) {
//                     List<Integer> pCopy = new ArrayList<>(p);
//                     pCopy.add(i, n);
//                     nextPerms.add(pCopy);
//                 }
//             }
//             perms = nextPerms;
//         }
//         return perms;
        List<List<Integer>> finalResult = new ArrayList<>();
        if (l == r) {
           List<Integer> myList = new ArrayList<>();
           for (int num: arr) {
               myList.add(num);
           }
           finalResult.add(myList);
        } else {
            for(int i=l; i<=r; i++) {
                swap(l, i, arr);
                finalResult.addAll(getPermutation(arr, l + 1, r));
                swap(l, i, arr);
            }
        }



        return finalResult;
    }


    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(getPermutation(arr, 0, arr.length -1));

//        sortMap();
    }

    private static void sortMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 3);
        map.put("banana", 2);
        map.put("cherry", 1);

        // Sort by values in ascending order
        Map<String, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())  // Sort by value
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(result);
    }

}

