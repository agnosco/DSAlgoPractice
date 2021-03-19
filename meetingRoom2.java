package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class meetingRoom2 {
    public static void main(String[] args) {
        int[][] meetings = new int[][]{{1,2}, {3,4}, {2,5}};

        System.out.println(new meetingRoom2().getNoOfRooms(meetings));
    }

    private int getNoOfRooms(int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparing((int[] meeting) -> meeting[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] interval:
             meetings) {
            if(heap.isEmpty()){
                count++;
            }else{
                if(interval[0] > heap.peek()){
                    heap.poll();
                }else{
                    count++;
                }
            }
            heap.offer(interval[1]);
        }
        return count;
    }
}
