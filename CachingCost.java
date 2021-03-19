package practice;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.*;

public class CachingCost {
    public static void main(String[] args) {
        List<String> edges = new ArrayList<>(Arrays.asList("1 2", "1 3", "2 4", "3 5", "7 8" ));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        System.out.println(new CachingCost().getCachingCost(10,edges));
    }

    private int getCachingCost(int n, List<String> edges) {
        Map<Integer, Integer> visitedMap = new HashMap<>();
        Map<Integer, List<Integer>> uniqueNetMap = new HashMap<>();

        for(String edge : edges){
            Integer e1 = Integer.valueOf(edge.split(" ")[0].trim());
            Integer e2 = Integer.valueOf(edge.split(" ")[1]);
            if(!visitedMap.containsKey(e1)){
                visitedMap.put(e1, e1);
                visitedMap.put(e2, e1);
            }else{
                visitedMap.put(e2, visitedMap.get(e1));
            }
//            List<Integer> inNetwork = uniqueNetMap.getOrDefault(visitedMap.get(e1), new ArrayList<>());
//            inNetwork.add(e2);
//            uniqueNetMap.put(visitedMap.get(e1), inNetwork);
            uniqueNetMap.computeIfAbsent(visitedMap.get(e1), s -> new ArrayList<>()).add(e2);
        }

        int max = 0;
        for(int i = 0; i <n ; i++){
            int count = 0;
            if(!visitedMap.containsKey(i)){
                count = 1;
            }else if(uniqueNetMap.containsKey(i)) {
                count = uniqueNetMap.get(i).size() + 1;
            }
            max += (int) Math.ceil(Math.sqrt(count));
        }

        return max;
    }
}
