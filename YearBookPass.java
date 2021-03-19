package practice;

import java.util.Arrays;

public class YearBookPass {
    public static void main(String[] args) {
        new YearBookPass().getMaxSignature(new int[]{4,3,2,1});
    }

    private int[] getMaxSignature(int[] arr) {

         int[] ans = new int[arr.length];
         Arrays.fill(ans, 1);

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (arr[j] != i + 1) {
                ans[i]++;
                j = arr[j] - 1;
            }
        }

        return ans;
    }
}
