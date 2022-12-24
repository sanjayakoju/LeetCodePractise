package leetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumberFormedFromArray {

    static String largestNumber(int nums[]) {

        List<Integer> list = new ArrayList<>();
        boolean isContain = false;
        for(int i=0;i<nums.length;i++) {
            list.add(Integer.valueOf(nums[i]));
            if (nums[i]>=1 && !isContain) isContain = true;
        }

        Collections.sort(list, (a,b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) +b));
        String largestStr = list.stream().map(Object::toString).collect(Collectors.joining(""));
        if (!isContain) return "0";
        return largestStr;

//        if (arr.length == 0) return 0;
//        else if (arr.length == 1) {
//            return arr[0];
//        }
//
//        long sum = 0;
//        for (int i=0;i<arr.length;i++) {
//            for (int j=i+1;j<arr.length;j++) {
//                int sumij = arr[i] + arr[j];
//                int sumji = arr[j] + arr[i];
//                if (sumij >= sumji) {
//                    sum = sum + sumij;
//                } else if (sumji >= sumij) {
//                    sum = sum + sumji;
//                }
//            }
//        }


    }

    public static void main(String[] args) {
//        int arr[] = {3,30,34,9};
//        int arr[] = {0, 0};
//        int arr[] = {8308,8308,830};
        int arr[] = {999999998,999999997,999999999};
        System.out.println(largestNumber(arr));
    }
}
