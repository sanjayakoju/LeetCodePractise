package datastucture.sorting;

import java.util.Arrays;

/**
 * Time Complexity O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int nums[] = {11,2,1,3,60,17,13};
        int size = nums.length;

        System.out.println(Arrays.toString(nums));

        System.out.println("Before Soring");

        for (int i=0;i<size-1;i++) {
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
            System.out.println();
            for (int num : nums) {
                System.out.printf(num + " ");
            }
        }

        System.out.println();
        System.out.println("After Sorting");
        for (int i=0;i<size-1;i++) {
            System.out.printf(nums[i] + " ");
        }
    }
}
