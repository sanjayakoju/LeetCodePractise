package coreJava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * To implement Binary Search the array must be in sorted order.
 * We need to declared to pointer low = 0 and high = len - 1
 * We need to find out mid-index of arrays
 * if mid-index is key element then key is found and terminate the algorithm
 * if key is less than mid-index then we need to search only left side of array and set high value to mid-index - 1
 * if key is greater than the key then low is mid-index + 1
 * if key is not found in the index then we return false and terminate the algorithm
 *
 * Time complexity: O(log n)
 */
public class BinarySearch {


    // Time complexity: O(log n)
    public static boolean binarySearch(int [] arr, int key) {

        int len = arr.length;
        int low = 0, high = len-1;

        // bubbleSort(arr);
        mergeSort(arr, low, high);

        System.out.println("Printing Sorted Arrays:");
        System.out.println(Arrays.toString(arr));

        while (low <= high) {
            int mid = (low + high)/2;
            if(arr[mid] == key) {
                return true;
            }

            if(key > arr[mid]) {
                low = mid+1;
            } else if (key < arr[mid]) {
                high = mid-1;
            }
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);
        return false;
    }

    // Time Complexity: O(n^2)
    private static void bubbleSort(int [] arr) {
        int len = arr.length;
        for (int i=0;i<len;i++) {
            for (int j=0;j<len-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    // Time Complexity: O(n log n)
    private static void mergeSort(int [] nums, int left, int right) {
        if(left < right) {
            int mid = (left + right)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int [] nums, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int [] leftArr = new int[len1];
        int [] rightArr = new int[len2];

        for (int i=0; i<len1; i++) {
            leftArr[i] = nums[left + i];
        }

        for (int j=0;j<len2;j++) {
            rightArr[j] = nums[mid + 1 + j];
        }

        int i=0, j=0;
        int k = left;

        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i<len1) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }

        while (j<len2) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,9,4,2,4,6,11,7,5};
        System.out.println("Key Found : "+binarySearch(arr, 5));
    }
}
