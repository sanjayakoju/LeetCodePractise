package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * Given an array of integers, find the length of the longest sub-sequence such that
 * elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 *
 * Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
 * Output: 4
 * Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
 *
 *
 * Input: arr[] = {36, 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
 * Output: 5
 * Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.
 */
public class Test {

    // Time complexity: O(N)
    // Space complexity: O(1)
    public static Number getSubSequence(int [] nums) {

        Vector<Integer> v = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        stack.search(10);
        Arrays.sort(nums); // O(n log n)
        int count = 1;
        int maxCount = 0;

        for (int i=0;i<nums.length - 1;i++) {
            int n = nums[i] + 1;
            if(n == nums[i+1]) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        System.err.println("Error message");
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(getSubSequence(new int[]{1, 9, 3, 10, 4, 20, 2}));

        List<Integer> list = new ArrayList<>();

        // check if length of args array is
        // greater than 0
        if (args.length > 0) {
            System.out.println(
                    "The command line arguments are:");
            // iterating the args array and printing
            // the command line arguments
            for (String val : args)
                System.out.println(val);
        }
        else
            System.out.println("No command line "
                    + "arguments found.");

        // Using Console to input data from user
//        String x = System.console().readLine();
//        System.out.println("You entered string " + x);
//        System.getSecurityManager();
        // javac Test.java
        // java Test.java hello world
        Integer i = 10;
        i = null;
        System.gc();

    }

    // Here overriding finalize method
    protected void finalize()
    {
        System.out.println("finalize method overridden");
    }
}
