package practice;

public class InsertionSort {
    public static void main(String[] args) {
        int[]  arr = new int[]{5,7,2,1,3,8,98};

        for(int i = 1; i < arr.length; i++){
            int k = arr[i];
            int j = i -1;
            while(j >= 0 && k < arr[j]){
                arr[i] = arr[j];
                arr[j] = k;
                j--;
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
