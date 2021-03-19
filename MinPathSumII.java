package practice;

public class MinPathSumII {

    public static void main(String[] args) {
        System.out.println(new MinPathSumII().minFallingPathSum(new int[][]{{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2}}
        ));
    }

    public int minFallingPathSum(int[][] arr) {

        int len = arr.length;
        for(int r = len -2; r >= 0; r--){
            for(int c = 0; c < len ; c++ ){
                int sum = Integer.MAX_VALUE;
                for(int i = 0; i < len; i++ ){
                    if(i != c){
                        sum = Math.min(sum, arr[r+1][i]);
                    }
                }
                arr[r][c] = sum + arr[r][c];
            }
        }

        int out =  arr[0][0];

        for(int i = 1; i < len; i++){
            out = Math.min(out, arr[0][i]);
        }
        return out;
    }
}
