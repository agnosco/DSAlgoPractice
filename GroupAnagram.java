package practice;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String sortedStr = String.valueOf(carr);
            map.computeIfAbsent(sortedStr, s -> new ArrayList<>()).add(str);
//            map.get(sortedStr).add(str);
        }

        List<List<String>> finalList = new ArrayList<>();
//        for (Map.Entry<String, List<String>> s: map.entrySet()) {
//            finalList.add(s.getValue());
//        }

        for (String key: map.keySet()) {
            finalList.add(map.get(key));
        }
//        return new ArrayList(map.values());
        System.out.println(finalList.get(1));
//        return finalList;
    }
}
