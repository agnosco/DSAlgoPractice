package practice;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class MazeEscape {
    public static void main(String[] args) {
        new MazeEscape().isEscapePossible(new int[][]{{1,0}}, new int[]{0,0}, new int[]{4,4});
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        return canEscape(blocked, new int[]{source[0]+1, source[1]}, target) || canEscape(blocked, new int[]{source[0], source[1]+1}, target);
    }

    private boolean canEscape(int[][] blocked, int[] source, int[] target ) {

        if(source[0] == target[0]&& source[1] == target[1] ){
            return  true;
        }
        if(!Arrays.stream(blocked).equals(source)){
            if(source[0] < target[0] ){
                 canEscape(blocked, new int[]{source[0]+1, source[1]}, target);
            }
            if(source[1] < target[1] ){
                canEscape(blocked, new int[]{source[0], source[1]+1}, target);
            }

        }
        Map<Integer, Integer> map = new LinkedHashMap<>(3);
        Set<Integer> set = new LinkedHashSet<Integer>(4);


        return false;
    }
}
