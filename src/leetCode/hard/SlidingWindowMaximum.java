package leetCode.hard;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
//        LinkedList<Integer> index = new LinkedList<>();
//        List<Integer> result = new ArrayList<>();
//        for(int i =0;i<nums.length;i++) {
//            while(index.size()>0 && index.getFirst() <= i-k)
//                index.removeFirst();
//            while (index.size()>0 && nums[i] >= index.getLast())
//                index.removeLast();
//            index.add(nums[i]);
//            if(i>=k-1)
//                result.add(index.getFirst());
//        }
//        return result.stream().mapToInt(x -> x).toArray();

        if(nums.length < k || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0, index = 0;
        for(i = 0; i < nums.length; i++){
            if(i - k >= 0 && !deque.isEmpty() && deque.peek() == i - k) deque.pollFirst();
            int add = nums[i];
            while(!deque.isEmpty() && add >= nums[deque.getLast()]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i - k + 1 >= 0) result[index++] = nums[deque.getFirst()];
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {7,2,4};
        int k = 2;
        int returnArr[] = maxSlidingWindow(arr,k);
        System.out.println(Arrays.toString(returnArr));
    }
}
