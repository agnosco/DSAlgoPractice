package practice;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
//        for(int i = 0; i < board.length; i++){
//            for (int j = 0; j < board[0].length; j++){
//                System.out.println(updatedBoard[i][j]);
//            }
//        }
    }

    private static void gameOfLife(int[][] board) {
        int[][] updatedBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                updatedBoard[i][j] = isaLive(i, j, board);
                System.out.println(updatedBoard[i][j]);
            }
        }
    }

    private static int isaLive(int i, int j, int[][] board) {
        int aliveNeighbours = 0 - board[i][j];
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && l >= 0 && k < board.length && l < board[0].length) {
                    aliveNeighbours += board[k][l];
                }
            }
        }

        if (board[i][j] == 1 && (aliveNeighbours < 2 || aliveNeighbours > 3)) {
            return 0;
        } else if (board[i][j] == 0 && aliveNeighbours == 3) {
            return 1;
        } else if (board[i][j] == 1 && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
            return 1;
        } else {
            return board[i][j];
        }

    }
}
