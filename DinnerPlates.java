package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class DinnerPlates {

    List<Stack<Integer>> stacks;
    int capacity;

    public DinnerPlates(int capacity) {
       this.stacks = new ArrayList<>();
       this.capacity = capacity;
    }

    public void push(int val) {
       for(Stack stack : stacks){
           if(stack.size() < capacity){
               stack.push(val);
               return;
           }
       }

       Stack<Integer> stack = new Stack<>();
       stack.add(val);
       stacks.add(stack);

    }

    public int pop() {
        for(int i = stacks.size() -1; i > 0; i ++){
            Stack<Integer> stack = stacks.get(i);
            if(stack.isEmpty()){
                stacks.remove(i);
            }else {
                return stack.pop();
            }
        }

        return  -1;
    }

    public int popAtStack(int index) {

        if(index >= stacks.size()){
            return  -1;
        }
        Stack<Integer> stack = stacks.get(index);
        if(stack.isEmpty()){
            return  -1;
        }

        return stack.pop();
    }
}
