package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcat {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[] {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {

        int noOfWords = words.length;
        int eachWordLength = words[0].length();
        List<Integer> list = new ArrayList<>();

        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for(String word : words){
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        for(int i=0; i < s.length(); i++){
            HashMap<String, Integer> tempMap = new HashMap<>(wordCountMap);
            if(s.length() >= i+ noOfWords*eachWordLength && windowContainsAll(s.substring(i, i+ noOfWords*eachWordLength), words, eachWordLength, tempMap)){
                list.add(i);
            }
        }
        return  list;
    }

    public static boolean windowContainsAll(String s, String[] words, int eachWordLength, HashMap<String, Integer> wordCountMap){

        if(s.length() < eachWordLength*words.length){
            return false;
        }


        for(int i=0; i < s.length(); i+=eachWordLength){
            String word = s.substring(i, i+eachWordLength);
            if(wordCountMap.containsKey(s.substring(i, i+eachWordLength)) && wordCountMap.get(s.substring(i, i+eachWordLength)) > 0){
                wordCountMap.put(word, wordCountMap.getOrDefault(word , 1) - 1);
                continue;
            }else{
                return false;
            }
        }
       return true;
    }
}
