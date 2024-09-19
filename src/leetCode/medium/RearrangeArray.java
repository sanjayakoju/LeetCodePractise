package leetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of elements of length N, ranging from 0 to N - 1. All elements may not be present in the array. If the element is not present then there will be -1 present
 * in the array. Rearrange the array such that A[il = i and if
 * i is not present, display -1 at that place.
 * Input : arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 * Output : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
 */
public class RearrangeArray {

    public List<Integer> rearrangeArray(List<Integer> arr) {
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            // Continue swapping until the current element is in the correct position
            while (arr.get(i) != -1 && arr.get(i) != i) {
                int correctIndex = arr.get(i);

                // If the correct index is out of bounds, set current position to -1
                if (correctIndex < 0 || correctIndex >= n) {
                    arr.set(i, -1);
                    break;
                }

                // If the target position already has the correct element, avoid infinite loop
                if (arr.get(correctIndex) == arr.get(i)) {
                    arr.set(i, -1);
                    break;
                }

                // Swap arr[i] with arr[correctIndex]
                int temp = arr.get(correctIndex);
                arr.set(correctIndex, arr.get(i));
                arr.set(i, temp);
            }
        }

        // After rearrangement, set any element not in its correct position to -1
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i) {
                arr.set(i, -1);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        RearrangeArray solution = new RearrangeArray();

        // Test Case 1
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(-1, -1, 6, 1, 9, 3, 2, -1, 4, -1));
        System.out.println("Original Array: " + arr1);
        List<Integer> rearranged1 = solution.rearrangeArray(arr1);
        System.out.println("Rearranged Array: " + rearranged1);
        // Expected Output: [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

        // Test Case 2
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(-1, 0, -1, 3, 2));
        System.out.println("\nOriginal Array: " + arr2);
        List<Integer> rearranged2 = solution.rearrangeArray(arr2);
        System.out.println("Rearranged Array: " + rearranged2);
        // Expected Output: [0, -1, 2, 3, -1]

        // Test Case 3
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(4, 3, 2, 7, 8, 2, 3, -1, 0));
        System.out.println("\nOriginal Array: " + arr3);
        List<Integer> rearranged3 = solution.rearrangeArray(arr3);
        System.out.println("Rearranged Array: " + rearranged3);
        // Expected Output: [0, -1, 2, 3, 4, -1, -1, 7, 8, -1]
    }
}
