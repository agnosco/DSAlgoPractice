package practice;

public class UniquePathWithObstacle {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}};
        int m = 2;
        int n = 3;
        int[][] dmap = new int[m][n];
        System.out.println(getUniquePath(m - 1, n - 1, grid, dmap));
        System.out.println(getUniquePathRecursive(m - 1, n - 1, grid, getDMap(m, n)));
    }

    public static int[][] getDMap(int i, int j) {
        int[][] dmap = new int[i][j];
        for (int a=0; a<i; a++) {
            for (int b=0; b<j; b++) {
                dmap[a][b] = -1;
            }
        }

        dmap[0][0] = 1;

        return dmap;
    }

    public static int getUniquePath(int m, int n, int[][] grid, int[][] dmap) {

        boolean obstaclefound = false;
        for (int i = 0; i <= m; i++) {
            if (grid[i][0] == 1 || obstaclefound) {
                dmap[i][0] = 0;
                obstaclefound = true;
            } else {
                dmap[i][0] = 1;
            }
        }

        obstaclefound = false;
        for (int i = 0; i <= n; i++) {
            if (grid[0][i] == 1 || obstaclefound) {
                dmap[0][i] = 0;
                obstaclefound = true;
            } else {
                dmap[0][i] = 1;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (grid[i][j] == 1) {
                    dmap[i][j] = 0;
                } else {
                    dmap[i][j] = dmap[i - 1][j] + dmap[i][j - 1];
                }
            }
        }

        return dmap[m][n];
    }

    public static int getUniquePathRecursive(int m, int n, int[][] grid, int[][] dmap) {

        if (dmap[m][n] != -1) {
            return dmap[m][n];
        }

        if (grid[m][n] == 1) {
            dmap[m][n] = 0;
            return 0;
        }

        int left = 0;
        if (m - 1 >= 0) {
            left = getUniquePathRecursive(m - 1, n, grid, dmap);
        }

        int up = 0;
        if (n - 1 >= 0) {
            up = getUniquePathRecursive(m, n - 1, grid, dmap);
        }

        dmap[m][n] = left + up;
        return dmap[m][n];

    }
}
