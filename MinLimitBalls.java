package practice;

public class MinLimitBalls {
    public static void main(String[] args) {
        new MinLimitBalls().minimumSize(new int[]{2, 4, 8, 4}, 4);
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int max = 1000;
        int min = 1;

        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] > max){
        //         max = nums[i];
        //     }
        // }
        while (min < max) {

            int mid = (min + max) / 2;
            int n = 0;
            for (int num : nums) {
                n += (num - 1) / mid;
            }

            if (n > maxOperations) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;

    }
}

