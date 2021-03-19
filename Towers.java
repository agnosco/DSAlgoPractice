package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Towers {

    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row1 = Arrays.asList(1,0,0,0);
        List<Integer> row2 = Arrays.asList(0,0,0,0);
        List<Integer> row3 = Arrays.asList(0,0,0,0);

        grid.add(row1);
        grid.add(row2);
        grid.add(row3);

        System.out.println(minimumDays(grid));
//        minimumDays(grid);

    }

    public static  int minimumDays(List<List<Integer>> grid)
    {
        // WRITE YOUR CODE HERE
        int days = 0;
        while (!isAllUpdated(grid)) {
            grid = update(grid);
            days += 1;
        }

        return days;
    }

    public static List<List<Integer>> update(List<List<Integer>> grid) {
        int[][] temp = new int[grid.size()][grid.get(0).size()];

        for (int row=0; row<grid.size(); row++) {
            List<Integer> aRow = grid.get(row);

            for (int column=0; column<aRow.size(); column++) {
                if (aRow.get(column) == 1) {
                    temp[row][column] = 1;
                    if (column - 1 >= 0) {
                        temp[row][column - 1] = 1;
                    }
                    if (column + 1 < aRow.size()) {
                        temp[row][column + 1] = 1;
                    }
                    if (row - 1 >= 0) {
                        temp[row - 1][column] = 1;
                    }
                    if (row + 1 < grid.size()) {
                        temp[row + 1][column] = 1;
                    }
                }

            }
        }

        return convertMatrixToArrayList(temp);
    }

   public static List<List<Integer>> convertMatrixToArrayList(int[][] tempGrid) {
        List<List<Integer>> retVal = new ArrayList<>();
        for (int i=0; i<tempGrid.length; i++) {
            List<Integer> aRow = new ArrayList<>();
            for (int j=0; j<tempGrid[i].length; j++) {
                aRow.add(tempGrid[i][j]);
            }
            retVal.add(aRow);
        }
        return retVal;
    }

    public static boolean isAllUpdated(List<List<Integer>> grid) {
        for (List<Integer> aRow : grid) {
            for (Integer i : aRow) {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
