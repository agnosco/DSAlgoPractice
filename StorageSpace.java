package practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StorageSpace {
    public static void main(String[] args) {
        new StorageSpace().getMaxSpace(3,3, Arrays.asList(2,3), Arrays.asList(1));
    }

    private void getMaxSpace(int h, int v, List<Integer> hbars, List<Integer> vbars) {
        int[] harr = new int[h];
        int[] varr = new int[v];

        for(int i = 0; i < hbars.size(); i++){

        }
    }
}
