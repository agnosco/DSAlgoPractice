package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    static Map<Character, Character> map = new HashMap<Character, Character>(){{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public static void main(String[] args) {

        System.out.println(isValid("()["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            if(map.containsValue(s.charAt(i) )){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek() != map.get(s.charAt(i))){
                    return false;
                }

                Math.abs(5-3);

                stack.pop();
            }
        }

        return stack.isEmpty();

    }
}
