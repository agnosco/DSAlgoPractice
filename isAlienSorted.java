package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class isAlienSorted {
    public static void main(String[] args) {
        System.out.println(new isAlienSorted().isAlienSorted(new String[]{"hello","l"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
        public boolean isAlienSorted(String[] words, String order) {
            Map<Character, Integer> wordMap = new HashMap<>();

            for(int i = 0; i < order.length(); i++){
                wordMap.put(order.charAt(i), i);
            }


            outer:
            for(int i = 1; i < words.length; i++){

                int k = 0;
                while(k < Math.min(words[i].length(), words[i-1].length())){
                    if(wordMap.get(words[i-1].charAt(k)) != wordMap.get(words[i].charAt(k))){
                        if(wordMap.get(words[i-1].charAt(k)) > wordMap.get(words[i].charAt(k))){
                            return false;
                        }
                        continue outer;
                    }
                    k++;
                }

                if (words[i -1].length() > words[i].length())
                    return false;

            }

            return true;
        }

}
