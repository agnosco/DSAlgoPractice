package practice;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        LinkedList<int[]> output = new LinkedList<>();

        Arrays.sort(intervals, (a, b) -> a[0] -b[0]);

        for(int i = 0; i < intervals.length; i++){
            if(output.isEmpty()){
                output.add(intervals[i]);
            }else{
                if(output.getLast()[0] <= intervals[i][0] && output.getLast()[1] >= intervals[i][0] ){
                    output.getLast()[1] = intervals[i][1];
                }else{
                    output.add(intervals[i]);
                }
            }
        }
        output.toArray();
        return;
    }
}
