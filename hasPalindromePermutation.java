package practice;

import java.util.HashMap;
import java.util.Map;

public class hasPalindromePermutation {
    public static void main(String[] args) {
        String s = "racecar";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int oddCount = 0;

        for(char c : map.keySet()){
            oddCount += map.get(c) % 2;
        }
//        return oddCount <= 1;
    }
}
