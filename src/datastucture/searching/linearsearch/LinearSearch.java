package datastucture.searching.linearsearch;

/**
 * Time Complexity O(n)
 */
public class LinearSearch {

    public static void main(String[] args) {
        int nums[] = {1,2,4,5,6,7,13};
        int target = 13;

        int result = linearSearch(nums, target);
        if (result!= -1) {
            System.out.printf("Element found at Index : "+result);
        } else {
            System.out.printf("Element Not Found!! ");
        }

    }

    public static int linearSearch(int[] nums, int target) {

        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
