package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2,3,3,3,4}));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int takePrev = 0;
        int notTakePrev = 0;
        int currentSum  = 0;
        int prev = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(i < nums.length - 1 && nums[i] == nums[i+1]){
                currentSum += nums[i];
            }else{
                int takeCurr = currentSum;
                int notTakeCurr = 0;

                if(i > 0 && nums[i] - prev  > 1){
                     takeCurr += Math.max(takePrev, notTakePrev) + nums[i];
                     notTakeCurr = Math.max(takePrev, notTakePrev);
                }else{
                     takeCurr += notTakePrev + nums[i];
                     notTakeCurr = Math.max(takePrev, notTakePrev);
                }

                takePrev = takeCurr;
                notTakePrev = notTakeCurr;
                currentSum = 0;
                prev = nums[i];
            }
        }

        return Math.max(takePrev, notTakePrev);

    }

}
