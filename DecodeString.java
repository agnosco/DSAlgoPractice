package practice;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        int position = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                position++;
            }else{
                stack.push(s.substring(i-position, i));
//                if()
            }
        }
    }




//    public static class Token {
//        public String str;
//        public int type;
//
//        Token(){}
//        Token(String s, int t) {
//            this.str = s;
//            this.type = t;
//        }
//    }
//
//    public static class Pair<T, E> {
//        T left;
//        E right;
//
//        Pair(){}
//        Pair(T t, E e) {
//            this.left = t;
//            this.right = e;
//        }
//    }
//
//    public static void main(String[] args) {
//        Stack<Token> stack = new Stack<>();
//
//        String s = "abc3[cd]xyz";
//        int nextTokenLocation = 0;
//        while (nextTokenLocation < s.length()) {
//            Pair<Token, Integer> t = getToken(s, nextTokenLocation);
//            nextTokenLocation = t.right;
//            if (t.left.type == 3) {
//                StringBuilder sb = new StringBuilder();
//                while (true) {
//                    Token stackTop = stack.pop();
//                    if (stackTop.type == 1) {
//                        String total = "";
//                        for (int i=0; i<Integer.valueOf(stackTop.str); i++){
//                            total += sb.toString();
//                        }
//                        stack.push(new Token(total, 0));
//                        break;
//                    } else if (stackTop.type != 2) {
//                        sb.insert(0, stackTop.str);
//                    }
//                }
//            } else {
//                stack.push(t.left);
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.insert(0, stack.pop().str);
//        }
//
//        System.out.println(sb.toString());
//    }
//
//    public static Pair<Token, Integer> getToken(String str, int indexToStartFrom) {
//        int start = indexToStartFrom;
//        int typeOf = getTypeOf(str, start);
//        if (typeOf == 2 || typeOf == 3) {
//            return new Pair(new Token(str.substring(start, start + 1), typeOf), start + 1);
//        } else {
//            if (typeOf == 1) {
//                while (start < str.length() && Character.isDigit(str.charAt(start))) {
//                    start++;
//                }
//            } else {
//                while (start < str.length() && Character.isAlphabetic(str.charAt(start)) && str.charAt(start) != '[' && str.charAt(start) != ']') {
//                    start ++;
//                }
//            }
//            return new Pair(new Token(str.substring(indexToStartFrom, start), typeOf), start);
//        }
//    }
//
//    public static int getTypeOf(String str, int start) {
//        if (Character.isDigit(str.charAt(start))) {
//            return 1;
//        } else if (str.charAt(start) == '[') {
//            return 2;
//        } else if (str.charAt(start) == ']') {
//            return 3;
//        }
//        return 0;
//    }
}
