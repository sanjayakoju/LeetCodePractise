package datastucture.searching.binarysearch;

/**
 * Time Complexity O(log n)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int nums[] = {1,2,4,5,6,7,13};
        int target = 13;
        int left = 0;
        int right = nums.length-1;

//        int result = binarySearch(nums, target);
        int result = binarySearchRecursive(nums, target, left, right);
        if (result!= -1) {
            System.out.printf("Element found at Index : "+result);
        } else {
            System.out.printf("Element Not Found!! ");
        }

    }

    private static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearchRecursive(nums, target, mid+1, right);
            } else if (nums[mid] > target) {
                return binarySearchRecursive(nums, target, left, mid -1);
            }
        }
        
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
           int mid = (left + right)/2;
           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid] < target) {
               left = mid + 1;
           } else if (nums[mid] > target) {
               right = mid - 1;
            }
        }


        return -1;
    }
    
    
}
