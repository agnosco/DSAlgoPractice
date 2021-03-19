package practice;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.
 */
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class NexxtPermutation {

    public static void main(String[] args) {
        int[] permutes = new int[]{3, 2, 1};
        String a = "fasdg";
        a.charAt(4);
        "a".equals("a");
//        for (int i=0; i<factorial(permutes.length); i++) {
        //new NexxtPermutation().nextPermutation(permutes);
            System.out.println(Arrays.toString(permutes));
//        }

    }
    public boolean nextPermutation(char[] nums) {

        int pivot = getPivot(nums);
        if (pivot == -1) { return false; }

        if(pivot != -1){
            int indexOfNextHighToPivot = getNextHighToPivot(pivot, nums);
            swap(pivot, indexOfNextHighToPivot, nums);
            //pivot += 1;
        }

        reverse(pivot+1, nums);
        return true;
    }

    private int getPivot(char[] nums){
        for(int i = nums.length -2; i >= 0 ; i --){
            if(nums[i] < nums[i +1]){
                return i;
            }
        }
        return -1;
    }

    private int getNextHighToPivot(int index, char[] nums){
        for(int i = nums.length -1; i > index; i--){
            if(nums[i] > nums[index]){
                return i;
            }
        }

        return -1;
    }

    private void swap(int pivot, int nextHigh, char[] nums){
        char temp = nums[pivot];
        nums[pivot] = nums[nextHigh];
        nums[nextHigh] = temp;
    }

    private void reverse(int pivot, char[] nums){
        int start = pivot;
        int end = nums.length -1;
        while(start <= end){
            char temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

//    private static int factorial(int val){
//        int multiple = 1;
//        for (int i=2; i<=val; i++) {
//            multiple *= i;
//        }
//        return multiple;
//    }
//
//    private static int[] getNextPermutation(int[] ints) {
//        int pivot = getPivot(ints);
//        if (pivot == -1) {
//            return reverse(ints, 0);
//        }
//        int q = getIndexOfLessThanPivotValue(ints, pivot);
//        swap(pivot, q, ints);
//        return reverse(ints, pivot+1);
//    }
//
//    private static int getIndexOfLessThanPivotValue(int[] ints, int pivot) {
//        for (int i=ints.length-1; i>pivot; i--) {
//            if (ints[pivot] < ints[i]) {
//                return i;
//            }
//        }
//        return -1; //Should never come here.
//    }
//
//    private static int getPivot(int[] ints) {
//        for (int i=ints.length-1; i>0; i--) {
//            if (ints[i] > ints[i-1]) {
//                return i-1;
//            }
//        }
//        return -1;
//    }
//
//    private static int[] swap(int small, int big, int[] ints) {
//        int temp = ints[big];
//       ints[big] = ints[small];
//       ints[small]= temp;
//        return ints;
//    }
//
//    private static int[] reverse(int[] ints, int start){
//        int end = ints.length -1;
//        while(start <= end){
//            int temp = ints[start];
//            ints[start++] = ints[end];
//            ints[end--] = temp;
//        }
//
//        return ints;
//    }
}
