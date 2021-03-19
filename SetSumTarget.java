package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetSumTarget {
    public static void main(String[] args) {

        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        a.add(new int[] {1,12});
        a.add(new int[] {2,3});
        a.add(new int[] {3,2});
        b.add(new int[] {1,5});
        b.add(new int[] {2,6});
        getPairs(a, b, 8);
    }

    private static void getPairs(List<int[]> a, List<int[]> b, int target){

        Collections.sort(a, (a1, a2) -> a1[1] -a2[1]);
        Collections.sort(b, (b1, b2) -> b1[1] -b2[1]);

        int i = 0;
        int j = b.size() -1;
        int max = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();
        while(i < a.size() && j >= 0){
            int sum =a.get(i)[1] + b.get(j)[1];
            if(sum <= target){
                if(sum > max ){
                    max = sum;
                    result.clear();
                    result.add(new int[] {a.get(i)[0], b.get(j)[0]});
                }else if(sum == max){
                    result.add(new int[] {a.get(i)[0], b.get(j)[0]});
                }
                i++;
            }else{
                j--;

            }
        }

        System.out.println(result.size());
        for(int k = 0; k < result.size(); k++){
            System.out.println(result.get(k)[0] + "==" + result.get(k)[1]);


        }

    }
}
