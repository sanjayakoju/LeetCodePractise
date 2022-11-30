package leetCode.easy;

public class SumOfTwo {

    public static int[] twoSum(int[] nums, int target) {
        int returnArr [] = new int[2];

        for(int i =0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if((nums[i]+nums[j]) == target) {
                    returnArr[0] = i;
                    returnArr[1] = j;
                    break;
                }

            }
        }
        return returnArr;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,0,9, 11};
        int target = 10;
        int[] returnIndex = twoSum(arr, target);
        for(int i =0;i<returnIndex.length;i++) {
            System.out.print(returnIndex[i] + " ");
        }
    }
}
