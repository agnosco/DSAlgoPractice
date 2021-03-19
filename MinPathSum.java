package practice;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinPathSum().getMinPathSum(grid, grid.length -1, grid[0].length-1));

    }

    public int getMinPathSum(int[][] grid, int r, int c){
        int[][] memo = new int[r][c];

        for(int i = 0; i < r ; i++ ){
            for(int j = 0; j < c; j++ ){
                if(i == 0 && j == 0){
                    memo[i][j] = grid[i][j];
                }else if(i == 0){
                    memo[i][j] = memo[i][j-1] + grid[i][j];
                }else if(j == 0){
                    memo[i][j] = memo[i-1][j] + grid[i][j];
                }else{
                    memo[i][j] = Math.min(memo[i-1][j]  + grid[i][j],  memo[i][j-1]  + grid[i][j]);

                }

            }

        }

        return memo[r-1][c-1] ;
    }
}
