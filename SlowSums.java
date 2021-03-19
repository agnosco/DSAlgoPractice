package practice;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class SlowSums {
    public static void main(String[] args) {
        new SlowSums().getMaxPenalty(new int[]{4,1,3,2});
        Stack<Character> stack = new Stack();
    }

    private void getMaxPenalty(int[] arr) {
        if(arr[0] == 4){
            return ;
        }
        Arrays.sort(arr);

        int penalty = 0;
        int sumOfTwo = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            sumOfTwo += arr[i];
            penalty += sumOfTwo;
        }
//        return penalty;
    }
}
