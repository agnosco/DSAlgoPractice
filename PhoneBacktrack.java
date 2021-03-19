package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBacktrack {

    static Map<String, String> digitMap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    static List<String> output = new ArrayList<>();

    public static void main(String[] args) {

        String digits = "23";
        if (digits.length() == 0) {
            System.out.println(output);
        }
        backtrack("", digits);
    }

//    public List<String> letterCombinations(String digits) {
//        if (digits.length() == 0) {
//            return output;
//        }
//
//        return backtrack("", digits);
//
//    }


    public static void backtrack(String combination, String nextDigits) {

        if (nextDigits.length() == 0) {
            output.add(combination);
        }else {
            String digit = nextDigits.substring(0, 1);
            String letters = digitMap.get(digit);

            for (int i = 0; i < letters.length(); i++) {
                backtrack(combination + letters.charAt(i), nextDigits.substring(1));
            }
        }


    }
}
