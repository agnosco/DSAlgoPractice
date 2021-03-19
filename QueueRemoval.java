package practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class QueueRemoval {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        System.out.println(new QueueRemoval().findPositions(new int[]{1,4,5}, 3));
    }

    private int computeMaxRemoval(Queue<Integer> arrQ, Queue<Integer> indexQ, int x) {
        int max = arrQ.peek();
        int maxIndex = indexQ.peek();

        Queue<Integer> tempArrQ = new LinkedList<>();
        Queue<Integer> tempIndexQ = new LinkedList<>();

        while(!arrQ.isEmpty() && x > 0){
            int e = arrQ.poll();
            int i = indexQ.poll();

            if(e > max){
                max = e;
                maxIndex = i;
            }
            tempArrQ.add(e-1 > 0? e-1 : 0);
            tempIndexQ.add(i);

            x--;
        }

        while(!tempArrQ.isEmpty()){
            if(tempIndexQ.peek() == maxIndex){
                tempArrQ.poll();
                tempIndexQ.poll();
            }else{
                arrQ.add(tempArrQ.poll());
                indexQ.add(tempIndexQ.poll());
            }


        }

        return maxIndex + 1;
    }

    int[] findPositions(int[] arr, int x) {
        // Write your code here
        Queue<Integer> arrQ = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();

        for(int j = 0; j < arr.length; j++){
            arrQ.add(arr[j]);
            indexQ.add(j);
        }

        int[] output = new int[x];
        int i = 0;
        while (i < x && !arrQ.isEmpty()){
            output[i] = computeMaxRemoval(arrQ, indexQ, x);
            i++;
        }
        return output;

    }


}
