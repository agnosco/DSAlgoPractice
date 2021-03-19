package practice;

import java.util.Arrays;

public class MaxGaap {
    public static void main(String[] args) {

        int[] nums = new int[]{5,8,2,3,6,9,4};
        Arrays.sort(nums);

        int max = 0;
        for (int i = 1; i < nums.length; i++) {

            if(max < (nums[i] - nums[i-1])){
                max = nums[i] - nums[i -1];
            }
        }

        System.out.println(max);
    }
}
