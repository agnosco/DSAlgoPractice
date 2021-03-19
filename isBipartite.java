package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class isBipartite {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1}, {0}};
        System.out.println(new isBipartite().isGraphBipartite(graph));
    }

    private boolean isGraphBipartite(int[][] graph) {
        Map<Integer, Character> visited = new HashMap<>();
        Queue<Integer> vertices = new LinkedList<>();
        Queue<Character> color = new LinkedList<>();

        vertices.add(0);
        color.add('R');

        while (!vertices.isEmpty()){
            int vertex = vertices.peek();
            int col = color.peek();
            char revColor = col == 'R' ? 'R' : 'P';

            if (visited.containsKey(vertex)) {
                 if(!color.peek().equals(visited.get(vertex))){
                     return false;
                }
                break;
            }else{
                visited.put(vertices.poll(), color.poll());
            }
            for (int edge : graph[vertex]) {
                vertices.add(edge);
                color.add(revColor);
            }
        }

        return true;
    }

    private Character setColor(int i, int[][] graph, Map<Integer, Character> visited) {
        if (visited.containsKey(i)) {
            return visited.get(i);
        }

        for (int edge : graph[i]) {
            if (visited.containsKey(edge)) {
                if (visited.get(edge) == 'R') {
                    return 'B';
                } else {
                    return 'R';
                }
            }
        }

        return 'R';
    }
}
