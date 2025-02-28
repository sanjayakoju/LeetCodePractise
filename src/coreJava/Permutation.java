package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [1,2,3] input
 * [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1];
 */
public class Permutation {

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static List<List<Integer>> getPermutation(int [] arr, int l, int r) {

        List<List<Integer>> finalResult = new ArrayList<>();
        if (l == r) {
           List<Integer> myList = new ArrayList<>();
           for (int num: arr) {
               myList.add(num);
           }
           finalResult.add(myList);
        } else {
            for(int i=l; i<=r; i++) {
                swap(l, i, arr);
                finalResult.addAll(getPermutation(arr, l + 1, r));
                swap(l, i, arr);
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(getPermutation(arr, 0, arr.length -1));
    }

}

