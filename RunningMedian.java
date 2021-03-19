package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RunningMedian().findMedian(new int[]{5,16,1,3})));

    }

    public int[] findMedian(int[] arr) {
        // Write your code here
        int[] medians = new int[arr.length];
        PriorityQueue<Integer> lowers = new PriorityQueue<>((a,b) -> b -a);
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            addToBucket(arr[i], lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    public int getMedian(PriorityQueue<Integer> lowers , PriorityQueue<Integer> highers){
        if(lowers.size() > highers.size()){
            return lowers.peek();
        }else if(lowers.size() < highers.size()){
            return highers.peek();
        }else{
            return (lowers.peek() + highers.peek()) /  2;
        }
    }

    public void addToBucket(int number, PriorityQueue<Integer> lowers , PriorityQueue<Integer> highers){
        if(lowers.size() == 0 || number < lowers.peek()){
            lowers.add(number);
        }else{
            highers.add(number);
        }
    }

    public void rebalance( PriorityQueue<Integer> lowers , PriorityQueue<Integer> highers){
        if(lowers.size() >=  highers.size() + 2){
            highers.add(lowers.poll());
        }else if(lowers.size() + 2 <=  highers.size()) {
            lowers.add(highers.poll());
        }
    }
}
