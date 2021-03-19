package practice;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1,0,2,-1});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>>  finalList = new ArrayList<>();

        for(int i = 2; i < nums.length; i++){
            int target = 0- (nums[i-1] + nums[i-2]);
            int j = i;
            while (nums[j] <= target){
                if(nums[j] == target){
                    finalList.add(new ArrayList<>(Arrays.asList(nums[i-1], nums[i-2], target)));
                }
                j++;
            }
        }

        return  finalList;

    }

    private List<Integer> findThirdSum(int num1, int num2, int p1, int p2, Map<Integer, Integer> map) {
        int target = 0- num1 -num2;
        if(map.containsKey(target) && map.get(target) != p1 || map.get(target) != p2){
            return new ArrayList<>(Arrays.asList(num1, num2, target));
        }
        return new ArrayList<>();
    }
}
