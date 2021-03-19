package practice;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "AAAAAAAAA";
        String t = "ABCD";
        System.out.println(new MinWindowSubstring().getMinSubstring(s, t));
    }

    private String getMinSubstring(String s, String t) {

        if(s.length() == 0 || t.length() == 0 || t.length() > s.length()){
            return  "";
        }

        Map<Character,Integer > mapT = createMapForT(t);

        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int[] indexMatchArray = new int[s.length()];
        int numsInWindow = 0;
        int k = 0;

        for(int i = 0; i < s.length(); i++){
            if(mapT.containsKey(s.charAt(i))){
                right = k;
                indexMatchArray[k] = i;

                if(numsInWindow == 0){
                    left = k;
                }
                numsInWindow++;
                k++;
            }
            if(numsInWindow == t.length()){
                if(start == 0 && end == 0 || (indexMatchArray[right] - indexMatchArray[left]  < end -start)){
                    start = indexMatchArray[left];
                    end = indexMatchArray[right];
                }

                if(end - start + 1 == t.length()){
                    return s.substring(start, end +1);
                }

                left = left + 1;
                numsInWindow--;
            }
        }

        return s.substring(start, end + 1);

    }

    private Map<Character,Integer > createMapForT(String t) {
        Map<Character,Integer > mapT = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return mapT;
    }
}
