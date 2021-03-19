package practice;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSumCombination {
    public static void main(String[] args) {
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(8);
        arr2.add(0);
        arr2.add(3);
        arr2.add(5);
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arr1.add(2);
        arr1.add(5);
        arr1.add(1);
        getMaxSumOf(arr1, arr2, 3);

        int[] a =  new int[] {1,2,3};
        System.out.println(a.length);
        List<Integer> numList = Arrays.stream(a).boxed().collect(Collectors.toList());
        numList.size();
    }

    private  static void getMaxSumOf(List<Integer> arr1, List<Integer> arr2, int n){


        Collections.sort(arr1, (a, b) -> b - a);
        Collections.sort(arr2, (a,b) -> b - a);

       List<Integer> finalArr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int x = 0;
        for(int i = n; i > 0; i--){
            int tempCount = 0;
            int y = 0;

            while(tempCount < i){
                pq.add(arr1.get(x) + arr2.get(y));
            }
            pq.add(arr1.get(x) + arr2.get(x));
            pq.add(arr1.get(i+1) + arr2.get(i));
            if(i == x){
                finalArr.add(pq.poll());
                x = 0;
            }
            x++;


        }


    }
}
