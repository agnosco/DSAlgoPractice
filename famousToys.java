package practice;

import java.lang.reflect.Array;
import java.util.*;

public class famousToys {
    public static void main(String[] args) {
        List<String> toys = Arrays.asList("Anacell", "Beta");
        List<String> quotes = Arrays.asList("Anacell  anacell beta the ", "Beta", "theta");

        System.out.println(topToys(2, toys, quotes));
    }

    public static List<String> topToys(int topNo, List<String> toys, List<String> quotes){

        Map<String, Integer> mapToys = new HashMap<>();

        for(String quote : quotes){
            for(String toy : toys){
                if(quote.toLowerCase().contains(toy.toLowerCase())){
                    mapToys.put(toy, mapToys.getOrDefault(toy, 0) + 1);
                }
            }
        }

        List<String> returnArray = new ArrayList<>(toys);
//        Collections.sort(returnArray, (a, b) ->
//                mapToys.getOrDefault(b, 0) - mapToys.getOrDefault(a, 0)
//                );

        Collections.sort(returnArray, Comparator.comparing(a -> -1* mapToys.getOrDefault(a, 0)));


        return returnArray;
    }

}
