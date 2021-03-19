package practice;

public class UniquePath {
    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        int[][] map = new int[m][n];
//        System.out.println(countUniquePaths(7, 3));
        System.out.println(uniquePathsWithMemo(7-1, 3-1, map));
    }

    public static int countUniquePaths(int m, int n){


        int[][] uniquePaths = new int[m][n];


        for(int i = 0; i < m; i ++){
            uniquePaths[i][0] = 1;
        }

        for(int i = 0; i < n; i ++){
            uniquePaths[0][i] = 1;
        }


        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                uniquePaths[row][col] = uniquePaths[row-1][col] + uniquePaths[row][col -1];
            }
        }

        return uniquePaths[m-1][n-1];
    }

    public int countRecursiveUniquePaths(int m, int n){
        if(m == 1 && n == 1){
            return 1;
        }

        if(m < 1 || n < 1){
            return 0;
        }

        return countUniquePaths(m -1, n) + countUniquePaths(m, n-1);
    }

    public static int uniquePathsWithMemo(int m, int n, int[][] dmap){
        if (dmap[m][n] != 0) {
            return dmap[m][n];
        }

        if (m < 1 || n < 1) {
            return 1;
        }

        int left = uniquePathsWithMemo(m - 1, n, dmap);
        int up = uniquePathsWithMemo(m, n - 1, dmap);

        dmap[m][n] = left + up;
        return dmap[m][n];

    }


}
