package leetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int n: nums) {
            set.add(n);
        }

        for (int n: nums) {
            // check if its the start of a sequence
            if(!set.contains(n-1)) {
                int length = 0;
                while (set.contains(n + length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2,5}));
    }
}
