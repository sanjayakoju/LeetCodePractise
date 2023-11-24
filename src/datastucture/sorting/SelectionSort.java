package datastucture.sorting;

/**
 * Time Complexity O(n^2) better than Bubble Sort
 */
public class SelectionSort {

    public static void main(String[] args) {
        int nums[] = {11,2,1,3,60,17,13};
        int size = nums.length;
        int temp;
        int minIndex = -1;

        for (int i=0;i<size-1;i++) {
            minIndex = i;
            for (int j=i+1; j<size;j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

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
