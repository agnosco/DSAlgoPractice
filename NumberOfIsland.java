package practice;

import sun.security.provider.certpath.Vertex;

import java.util.*;

public class NumberOfIsland {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid1 = new char[][]{
                {'1','1'},
                {'1','0'}
        };

        System.out.println(getNumberOfIslands(grid));

    }

    public static int getNumberOfIslands(char[][] grid) {

        Map<String, List<String>> graph = createGraph(grid);
        Map<String, Boolean> visited = new HashMap<>();

        int noOfIsland = 0;
        Stack<String> stack = new Stack<>();
        for (String key : graph.keySet()) {

            if (visited.containsKey(key)) {
                continue;
            } else {
                stack.push(key);

                while (!stack.isEmpty()) {
                    String temp = stack.pop();
                    visited.put(temp, true);
                    for (String s : graph.get(temp)) {
                        if (!visited.containsKey(s)) {
                            stack.push(s);
                        }
                    }
                }

                noOfIsland++;
            }
        }
            return noOfIsland;
    }

    private static Map<String, List<String>> createGraph(char[][] grid) {
        Map<String, List<String>> graph = new HashMap<>();
        int r = grid.length;
        int c= grid[0].length;
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){

                if(grid[i][j] == '1') {
                    List<String> values = new ArrayList<>();

                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        values.add(Integer.toString(i - 1) + Integer.toString(j));
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        values.add(Integer.toString(i) + Integer.toString(j - 1));
                    }
                    if (i + 1 < r && grid[i + 1][j] == '1') {
                        values.add(Integer.toString(i + 1) + Integer.toString(j));
                    }
                    if (j + 1 < c && grid[i][j + 1] == '1') {
                        values.add(Integer.toString(i) + Integer.toString(j + 1));
                    }
                    graph.put(Integer.toString(i) + Integer.toString(j), values);
                }
            }
        }
        return graph;
    }

//    private static String getAnUnvisitedNode(Map<String, Boolean> Unvisited){
//        for (String s: Unvisited.keySet()) {
//            if(!Unvisited.get(s)){
//                return s;
//            }
//
//        }
//
//        return null;
//    }
}
