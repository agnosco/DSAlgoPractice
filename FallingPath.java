package practice;

public class FallingPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2, 1}, {6, 5}};
        System.out.println(new FallingPath().minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            sum = Math.min(sum, getPath(0, i, matrix, matrix[0][i]));
        }

        return sum;
    }

    public int getPath(int row, int col, int[][] matrix, int sum) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(row >= m - 1 || col < 0 || col > n -1 ){
            return sum;
        }
         sum =  sum + getPath(row + 1, col, matrix, matrix[row +1][col]);

        if(col > 0){
            sum = Math.min(sum, getPath(row + 1, col - 1, matrix, matrix[row + 1][col -1]));
        }

        if(col + 1 < n){
            sum = Math.min(sum, getPath(row + 1, col, matrix, matrix[row + 1][col]));
        }


        return sum;    }

    public boolean isValid(int row, int col, int m, int n) {
        if (row <= m - 1 && col < 0) {
            return false;
        }

        if (row <= m - 1 && col > n) {
            return false;
        }

        return true;
    }
}

