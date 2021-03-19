package practice;

public class CanFormArray {
    public static void main(String[] args) {
        int[] arr = new int[]{49,18,16};
        int[][] pieces = new int[][]{{49},{16, 18}};

        System.out.println(checkArrayForm(arr, pieces));
    }

    private static boolean checkArrayForm(int[] arr, int[][] pieces) {
        boolean checkArrayForm = false;
        for (int[] piece : pieces) {
            boolean found = false;
            int j = 0;
            for (int i = 0; i < piece.length; i++) {
                while(j < arr.length){
                    if (arr[j] == piece[i]) {
                        checkArrayForm = true;
                        found = true;
                        break;
                    } else if (found == true) {
                        return false;
                    }
                    j++;
                }
                 j++;
            }

            found = false;

        }
        return checkArrayForm;
    }
}
