package practice;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = new int[]{8,1,6,3};
        int[] value = new int[]{100, 1,72,33};
        int maxWeight = 9;

        System.out.println(getMaxValue(weight, value, maxWeight, 0));
    }

    public  static int getMaxValue(int[] weights, int[] values, int w, int pos){
        if(weights.length <= pos){
            return 0;
        }

        if(w >= weights[pos]){
            return  Math.max(getMaxValue(weights, values, w - weights[pos], pos + 1) + values[pos],
                            getMaxValue(weights, values, w, pos + 1) + 0);
        }else{
           return getMaxValue(weights, values, w , pos + 1);
        }
    }
}
