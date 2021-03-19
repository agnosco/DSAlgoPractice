import java.util.Stack;

public class LongestParenthesis {
    public static void main(String[] args) {
        String parenthesis = ")()())";
        System.out.println(getLengthLongestParenthesis(parenthesis));
    }

    private static int getLengthLongestParenthesis(String parenthesis) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for(int i = 0; i < parenthesis.length(); i++){
            if(parenthesis.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
