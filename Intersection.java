package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[] {2,2};
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2){
            set2.add(num);
        }

         set1.retainAll(set2);
        Arrays.asList(set1);

    }

}
