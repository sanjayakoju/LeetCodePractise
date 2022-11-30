package leetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int l = height.length;
        int i=0;
        int max = height[i];
        int maxIndex = 0;
        int minIndex = height.length-1;
        while(i<l) {
            if(max < height[i]) {
                max = height[i];
                maxIndex = i;
                break;
            }
            i++;
        }

        int maxMinusMin = maxMinusMinIndex(height, maxIndex);

        if(height[maxIndex] > height[minIndex]) {
            return height[minIndex]  * maxMinusMin;
        } else {
            return height[maxIndex] * maxMinusMin;
        }
    }

    public static int maxMinusMinIndex(int [] height, int max) {
        int min = height[max];
        int minIndex = 0;
        for(int i = 0; i< height.length; i++) {
            int a = height[i];
            if (a < min) {
                min = height[i];
                minIndex = i;
            }
        }

        return Math.abs(max - minIndex);
    }

    public static void main(String[] args) {
//        int arr [] = {4,3,2,1,4};
//        int arr [] = {1,8,6,2,5,4,8,3,7};
        int arr [] = {1,1};
        System.out.println(maxArea(arr));
        System.out.println(maxArea2(arr));
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        list.isEmpty();
        list.size();
    }


    public static int maxArea2(int[] height) {
        // Maximum area will be stored in this variable
        int maximumArea = Integer.MIN_VALUE;
        // Left and right pointers
        int left = 0;
        int right = height.length - 1;
        // Loop until left and right meet
        while (left < right) {
            // Shorter pole/vertical line
            int shorterLine = Math.min(height[left], height[right]);
            // Update maximum area if required
            maximumArea = Math.max(maximumArea, shorterLine * (right - left));
            // If there is a longer vertical line present
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumArea;
    }
}
