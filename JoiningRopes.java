package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JoiningRopes {

    public static void main(String[] args) {
        List<Integer> ropes  = new ArrayList<>();
        ropes.add(8);
        ropes.add(4);
        ropes.add(6);
        System.out.println(joinRopes(ropes));
    }

    public static int joinRopes(List<Integer> ropes){

        int finalSum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(ropes);

        while(queue.size() >= 2){
            int sum = queue.poll() + queue.poll();
//            if(!queue.isEmpty())
                queue.add(sum);
            finalSum += sum;
        }
        return finalSum;
    }
}
