package practice;

import java.util.*;

public class ToCityZero {
    public static void main(String[] args) {
        int count = new ToCityZero().getPathCount(6, new int[][]{
                {0,1},
                {1,3},
                {2,3},
                {4,0},
                {4,5}
        });
        System.out.println(count);
    }

    private int getPathCount(int n, int[][] connections) {
        Set<Integer> visitedSet = new HashSet<>();
        Stack<Integer> queue = new Stack<>();
        queue.add(0);
        int count = 0;
        while (!queue.isEmpty()) {

            int city = queue.pop();
            visitedSet.add(city);
            List<int[]> children = getChildren(city, connections);
            for (int[] child : children) {
                if (!visitedSet.contains(child[0])) {
                    queue.add(child[0]);
                    if (child[1] == 1) { count ++; }
                }
            }
        }

        return count;
    }

    private List<int[]> getChildren(int city, int[][] connections) {
        List<int[]> children = new ArrayList<>();
        for (int[] connection : connections) {
            int city1 = connection[0];
            int city2 = connection[1];
            if (city1 == city) {
                children.add(new int[]{city2, 1});
            } else if(city2 == city) {
                children.add(new int[]{city1, -1});
            }
        }
        return children;
    }
}
