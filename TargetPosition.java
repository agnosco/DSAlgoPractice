package practice;

import java.util.HashMap;
import java.util.Map;

public class TargetPosition {
    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[]{1, 4};

        Map<Integer, Integer>[] rowsMap = new HashMap[9];
        for(int i = 0; i < 9; i++){
            rowsMap[i] = new HashMap<Integer, Integer>();
        }
        rowsMap[1].get(9);

        if (nums.length == 1 && 4 == nums[0]) {
            System.out.println( new int[]{0, 0});
        }
        search(0, nums.length - 1, 4, nums);
    }

    public static int[] search(int start, int end, int target, int[] nums) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return getIndices(mid, nums, target);
            } else if (target > nums[mid]) {
                start = mid + 1;
                end = nums.length - 1;
            } else {
                start = 0;
                end = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }


    public static  int[] getIndices(int mid, int[] nums, int target) {
        int high = mid;
        int low = mid;

        while ((high + 1 < nums.length && nums[high + 1] == target) || (low - 1 >= 0 && nums[low - 1] == target)) {
            if (high + 1 < nums.length && nums[high + 1] == target) {
                high++;
            }
            if (low - 1 >= 0 && nums[low - 1] == target) {
                low--;
            }
        }
        return new int[]{low, high};
    }

}