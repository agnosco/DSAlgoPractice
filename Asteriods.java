package practice;

import java.util.*;
import java.util.stream.Collectors;

public class Asteriods {
    public static void main(String[] args) {
        new Asteriods().asteroidCollision(new int[]{-2,2,-1,-2});
    }
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (stack.peek() > 0 && asteroids[i] < 0) {
                getOppositeResult(stack, asteroids[i]);
            } else {
                stack.push(asteroids[i]);
            }
        }

        int[] out = new int[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            out[j--] = stack.pop();
        }

        return out;
    }

    public Stack<Integer> getOppositeResult(Stack<Integer> stack, int cur) {
        int absCur = Math.abs(cur);
        if (absCur == stack.peek()) {
            stack.pop();
        } else if (absCur > stack.peek()) {
            while (stack.peek() > 0 && absCur >= stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() < 0) {
                stack.push(cur);
            }
        }

        return stack;
    }


    public void arrayMaps(){
        int[] ints = new int[]{1,2,3,4};
        Integer[] integers = Arrays.stream(ints).boxed()
                    .toArray(Integer[] :: new);
        List<Integer> list = Arrays.stream(ints).boxed()
                .collect(Collectors.toList());
        List<int[]> list1 =  Arrays.asList(ints);
        List<Integer> ints2 = Arrays.asList(integers);
        int[] ints1 = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        System.out.println("test");

        Map<Character, Integer> rMap = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('I', 1);
            put('I', 1);
            put('I', 1);
            put('I', 1);
            }};

    }
}
