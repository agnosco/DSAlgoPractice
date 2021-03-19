package practice;

public class InverseArray {
    public static void main(String[] args) {
        System.out.println(new InverseArray().getInverseCount(new int[]{5, 2, 3, 1}));
        //System.out.println(new InverseArray().getInverseCountMerge(new int[]{4,3,1,2,5}).toString());
    }

    private int[] getInverseCountMerge(int[] arr) {
        divide(arr, 0, arr.length -1);
        return arr;
    }

    private void divide(int[] arr, int start, int end) {
        while(start < end){
            int mid = (start + end)/2;
            divide(arr, start, mid);
            divide(arr, mid+1, end);
            merge(arr, start, end, mid);
        }
    }

    private void merge(int[] arr, int start, int end, int mid) {

        int[] target = new int[end -start + 1];
        int s = start;
        int m = mid + 1;
        int i = 0;
        while(s <= mid && m <= end){
            if(arr[s] > arr[m]){
                target[i] = arr[m];
                m++;
            }else {
                target[i] = arr[s];
                s++;
            }
            i++;
        }

        while(s <= mid){
            target[i] = arr[s];
            s++;
        }

        while (m <= end){
            target[i] = arr[m];
            m++;
        }

        for(int j = 0; j < target.length; j++){
            arr[start] = target[j];
            start++;
        }
    }

    public int getInverseCount(int[] arr){
        int count = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    count++;
                    System.out.println("(" + arr[i] + ": " + arr[j] + ", ");
                }
            }
        }
        return  count;
    }
}
