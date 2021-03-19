package practice;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.push(10);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        MinStack stack1 = new MinStack();
        stack1.push(5);
        System.out.println(stack1.getMin());
        System.out.println(stack1.top());
        stack1.push(2);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        System.out.println(stack1.getMin());
        System.out.println(stack1.top());


    }

    public List<int[]> stack ;
    /** initialize your data structure here. */
    public MinStack() {
        stack =  new ArrayList<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.add(new int[]{x, x});
        }
       int min = Math.min(x, stack.get(stack.size() -1)[1] );
        stack.add(new int[]{x, min});
    }

    public void pop() {
        stack.remove(stack.size() -1);
    }

    public int top() {
       return stack.get(stack.size() -1)[0];
    }

    public int getMin() {
        return stack.get(stack.size() -1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */