package algorithm.twoPointers;

import java.util.Arrays;

public class DutchNationalFlagProblem {

    public static void solution(int arr[]) {
        int l = 0,m=0,h=arr.length-1;
        int temp;
        while(m<=h) {
            switch(arr[m]) {
                case 0:
                    temp = arr[m];
                    arr[m] = arr[l];
                    arr[l] = temp;
                    l++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    temp = arr[m];
                    arr[m] = arr[h];
                    arr[h] = temp;
                    h--;
                    break;

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = {0,1,1,2,0,2};
        solution(arr);
    }
}
