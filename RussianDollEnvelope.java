package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelope {

    public static void main(String[] args) {
        int[][] envelopes = new int[][] {{5,4},{6,4},{6,7},{2,3}};
        int k = 2;

        System.out.println(getMaxEnvelope(envelopes));
    }

    private static int getMaxEnvelope(int[][] envelopes ) {

        int[][] sortedEnvelopes = sortArray(envelopes);
        ArrayList<Integer> list = new ArrayList<>();
        for(int[] arr: sortedEnvelopes){
            int target = arr[1];

            if(list.isEmpty()||target>list.get(list.size()-1)){
                list.add(target);
            }else{
                int i=0;
                int j=list.size()-1;

                while(i<j){
                    int m = i + (j-i)/2;
                    if(list.get(m)>=target){
                        j = m;
                    }else{
                        i = m+1;
                    }
                }

                list.set(j, target);
            }
        }

        return list.size();
    }

    private static int[][] sortArray(int[][] envelopes) {

        Comparator c = Comparator.comparing((int[] arr) -> arr[0])
                                .thenComparing((int[]arr) -> arr[1],Comparator.reverseOrder());
        Arrays.sort(envelopes, c);
        return envelopes;
    }
}
