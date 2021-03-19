package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCandy {
    public static void main(String[] args) {
        System.out.println(new MaxCandy().getMaxCandy(new int[]{2, 1, 7, 4, 2}, 3));
        System.out.println(new MaxCandy().getMaxCandyHeap(new int[]{2, 1, 7, 4, 2}, 3));
    }

    private int getMaxCandyHeap(int[] arr, int k) {
        int candies = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0; i < arr.length; i++){
            heap.add(arr[i]);
        }
        while(k > 0){
            int max = heap.poll();
            candies += max;
            heap.add(max/2);
            k--;
        }
        return candies;
    }

    private int getMaxCandy(int[] arr, int k) {
        int candies = 0;
        while(k > 0){
            int max = arr[0];
            int maxIndex = 0;
            for(int i = 1; i < arr.length; i++){
                if(arr[i] > max){
                    max = arr[i];
                    maxIndex = i;
                }
            }
             k--;
            candies += max;
            arr[maxIndex] = max/2;
        }

        return candies;
    }
}
