package practice;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        List<List<Integer>> uniqueSums = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> uniqueFirst = new ArrayList<>();
//        List<Integer> uniqueSecond = new ArrayList<>();

        List<Integer> sortedNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(sortedNums);
        if(nums.length < 3){
//            return uniqueSums;
        }
        for(int i = 0; i < nums.length; i++) {
            if (!uniqueFirst.contains(nums[i])) {
                uniqueFirst.add(nums[i]);
                List<Integer> uniqueSecond = new ArrayList<>();
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (!uniqueSecond.contains(nums[j])) {
                        uniqueSecond.add(nums[j]);
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] + nums[k] + nums[i] == 0) {
                            List<Integer> ints = new ArrayList<>();
                            ints.add(nums[i]);
                            ints.add(nums[j]);
                            ints.add(nums[k]);
                            System.out.println("[" + nums[i] + "-" + nums[j] + "-" + nums[k] + "],");
                            uniqueSums.add(ints);
                        }
                        break;
                    }
                    }
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> uniqueSums = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        List<Integer> uniqueFirst = new ArrayList<>();
        if(nums.length < 3){
            return uniqueSums;
        }
        for(int i = 0; i < nums.length; i++) {
            if (!uniqueFirst.contains(nums[i])) {
                uniqueFirst.add(nums[i]);
                List<Integer> uniqueSecond = new ArrayList<>();
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (!uniqueSecond.contains(nums[j])) {
                        uniqueSecond.add(nums[j]);
                        for (int k = j + 1; k < nums.length; k++) {
                            if (nums[j] + nums[k] + nums[i] == 0) {
                                List<Integer> ints = new ArrayList<>();
                                ints.add(nums[i]);
                                ints.add(nums[j]);
                                ints.add(nums[k]);

                                uniqueSums.add(ints);
                            }
                            break;
                        }
                    }
                }
            }
        }
        return uniqueSums;

    }

}
