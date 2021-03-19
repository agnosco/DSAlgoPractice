package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestKsubstring {
    public static void main(String[] args) {
        String s= "abbacb";
        int k = 2;
        System.out.println(longestSubstring(s, k));

    }
    public static  int longestSubstring(String s, int k) {

        Map<Character, Integer> charMap = new HashMap<>();
        int substringLength = 0;
        for(int i = 0; i < s.length(); i++){
            charMap.put(s.charAt(i),  charMap.getOrDefault(s.charAt(i), 0) + 1);
            if(charMap.getOrDefault(s.charAt(i),0) == k){
                substringLength+=k;
            }else if(charMap.getOrDefault(s.charAt(i),0) > k){
                substringLength++;
            }


        }

        return substringLength;

    }
}
