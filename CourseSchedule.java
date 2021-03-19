package practice;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    static Map<Integer, List<Integer>> graph = new HashMap<>();

    static List<Integer> toBeVisited = new ArrayList<>();
    static List<Integer> visting = new ArrayList<>();
    static List<Integer> visited = new ArrayList<>();

    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {{1,0}};
        int courseToTake = 2;
        System.out.println(canFinish(courseToTake, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i=0; i<numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            int[][] minDungeon = new int[9][4];
            int r = minDungeon.length;
            int c = minDungeon[0].length;
        }

       toBeVisited = new ArrayList<>(graph.keySet());
        while (!toBeVisited.isEmpty()){
            int nodeToBeVisited = toBeVisited.get(0);
            if(!DFSCheckPrerequisite(toBeVisited.get(0))){
                return false;
            }

            toBeVisited.remove(nodeToBeVisited);
        }

        return true;
    }

    private static boolean DFSCheckPrerequisite(int node) {

        if(visting.contains(node)){
            return false;
        }
        visting.add(node);

        for(Integer child : graph.get(node)) {
            if(!DFSCheckPrerequisite(child)){
                return false;
            }
        }

        visting.remove(node);
        visited.add(node);

        return true;
    }
}
