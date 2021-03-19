package practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12,11,6,7};
        new MergeSort().divide(arr, 0, arr.length );
        System.out.println(Arrays.toString(arr));
    }

    private void divide(int[] ints, int start, int end) {
        if(start < end){
            int mid = (start + end)/2;
            divide(ints, start, mid);
            divide(ints, mid + 1, end);
            merge(ints, start, mid, end);
        }
    }

    private void merge(int[] ints, int start, int mid, int end) {
        int[] target = new int[start + end + 1];
        int i = 0;
        int k = start;
        int l = mid + 1;
        while(k <= mid && l <= end){
            if(ints[l] > ints[k] || l == end){
                target[i] = ints[k];
                k++;
            }else{
                target[i] = ints[l];
                l++;
            }
            i++;
        }

        while (k <= mid){
            target[i++] = ints[k++];
        }
        while (l <= end){
            target[i++] = ints[l++];
        }

        for(int j = 0; j < target.length; j++){
            ints[start] = target[j];
            start++;
        }
    }
}
