package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
    }

    static int n=0,m=0 ;
    public static void solve(char[][] board) {
        n = board.length ;
        if(n == 0) return ;
        m = board[0].length ;
        boolean[][] notCaptured = new boolean[n][m] ;
        for(int i=0;i<n; i++){
            for(int j=0;j<m;j++){
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && board[i][j] == 'O'){
                    f(board, notCaptured, i,j) ;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(notCaptured[i][j]) board[i][j] = 'O' ;
                else board[i][j] = 'X' ;
            }
        }
        return ;
    }
    private static void f(char[][] arr, boolean[][] notCaptured, int i, int j){
        if(i <0 || j<0 || i>=n || j>= m || notCaptured[i][j] || arr[i][j] == 'X') return ;
        notCaptured[i][j] = true;
        f(arr,notCaptured, i+1,j) ;
        f(arr,notCaptured, i,j+1) ;
        f(arr,notCaptured, i-1,j) ;
        f(arr,notCaptured, i,j-1) ;
    }
}
