package practice;

public class minCost {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;

        int[][] minDungeon = new int[r + 1][c +1];
        minDungeon[0][0] = 0;
        int sum = 0;
        for(int i = 1; i < r; i++){
            minDungeon[i][0] = sum + dungeon[i-1][0];
            sum = minDungeon[i][0];
        }

        for(int j = 1; j < c; j++){
            minDungeon[0][j] = sum + dungeon[0][j-1];
            sum = minDungeon[0][j];
        }

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(i-1 > 0 && j-1 > 0){
                    minDungeon[i][j] = dungeon[i-1][j-1] + Math.min(minDungeon[i][j -1], minDungeon[i-1][j]);
                }
            }
        }

        return minDungeon[r][c];


    }
}
