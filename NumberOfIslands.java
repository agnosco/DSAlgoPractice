package practice;

import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A"));
        graph.put("D", Arrays.asList("E"));
        graph.put("C", new ArrayList<>());
        graph.put("E", new ArrayList<>());

        System.out.println(getNumberOfIslands(graph));
    }

    private static int getNumberOfIslands(Map<String, List<String>> graph) {

        int numIslands = 0;
        Map<String, Boolean> visited = new HashMap<>();
        for (String key :
                graph.keySet()) {
            if (visited.containsKey(key)) {
                continue;
            } else {

                Stack<String> stack = new Stack<>();
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
                numIslands++;
            }
        }
        return numIslands;
    }











//        Map<String, Boolean> unvisited = new HashMap<>();
//
//        for (String s: graph.keySet()){
//            unvisited.put(s, false);
//        }
//
//        String n = null;
//        int noOfIsland = 0;
//        Stack<String> stack = new Stack<>();
//        while ((n = getAnUnvisitedNode(unvisited)) != null){
////            dfs(n, Unvisited, graph);
//            stack.push(n);
//
//            while (!stack.isEmpty()){
//                String temp = stack.pop();
//                unvisited.put(temp, true);
//                for (String s : graph.get(n)){
//                    if(!unvisited.get(s)){
//                        stack.push(s);
//                    }
//                }
//            }
//
//            noOfIsland++;
//        }
//
//
//        return  noOfIsland;
    //}

    private static void dfs(String n, Map<String, Boolean> unvisited, Map<String, List<String>> graph) {
        unvisited.put(n, true);
        for (String s : graph.get(n)){
            if(!unvisited.get(s)){
                dfs(s, unvisited, graph);
            }
        }
    }

    private static String getAnUnvisitedNode(Map<String, Boolean> Unvisited){
        for (String s: Unvisited.keySet()) {
            if(!Unvisited.get(s)){
                return s;
            }

        }

        return null;
    }
}
