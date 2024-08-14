package datastucture.sorting;

import java.util.Arrays;

/**
 * Time Complexity O(n^2) better than Bubble Sort
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {11,2,1,3,60,17,13};
        System.out.println("Before");
        System.out.println(Arrays.toString(nums));

        int size = selectionSort(nums);

        System.out.println();
        System.out.println("After Sorting");
        for (int i=0;i<size-1;i++) {
            System.out.printf(nums[i] + " ");
        }
    }

    private static int selectionSort(int[] nums) {
        int size = nums.length;
        int minIndex;

        for (int i=0; i<size-1; i++) {
            minIndex = i;
            for (int j=i+1; j<size; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
            print(nums);
        }
        return size;
    }

    private static void swap(int[] nums, int minIndex, int i) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
    }

    private static void print(int[] nums) {
        System.out.println();
        for (int num : nums) {
            System.out.printf(num + " ");
        }
    }
}
