package datastucture.sorting;

/**
 * Time Complexity O(n log n) Divide and conquer
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {11,22,1,3,60,17,13};
        int size = nums.length;
        int low = 0;
        int high = size-1;
        quickSort(nums, low, high);

        System.out.println();
        System.out.println("After Sorting");
        for (int num : nums) {
            System.out.printf(num + " ");
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low<high) {
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi - 1);
            quickSort(nums, pi + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, high);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
