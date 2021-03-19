package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subString {
    public static void main(String[] args) {
        letterCombinations(" 23");
    }
    public static List<String> letterCombinations(String digits) {
        Map<String, String> mapOfDigits = new HashMap<>();
        mapOfDigits.put("2", "abc");
        mapOfDigits.put("2", "abc");
        mapOfDigits.put("3", "def");



        List<String> subString = new ArrayList<>();
        subString.add("");
        int i = 0;
        while(digits.length()  > i){
            if(mapOfDigits.get(String.valueOf(digits.charAt(i))) != null) {
                subString = getsubstring(subString, mapOfDigits.get(String.valueOf(digits.charAt(i))));
            }
            i++;
        }

        return subString;
    }

    public static List<String> getsubstring(List<String> tempSubString, String letters){
        int i = 0;
        List<String> finalSubStrings = new ArrayList<>();
        while(letters.length() >  i){
            for(String subString : tempSubString){
                finalSubStrings.add(subString + String.valueOf(letters.charAt(i)));
            }
            i++;
        }

        return finalSubStrings;

    }
}