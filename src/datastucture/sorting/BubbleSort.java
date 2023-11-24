package datastucture.sorting;


/**
 * Time Complexity O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int nums[] = {11,2,1,3,60,17,13};
        int size = nums.length;
        int temp;

        System.out.printf("Before Sorting");
        for (int i=0;i<size-1;i++) {
            for (int j=0;j<size-1;j++) {
                if (nums[j] > nums[j+1]) {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
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
