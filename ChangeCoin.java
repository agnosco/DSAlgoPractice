package practice;

import java.util.Arrays;

public class ChangeCoin {
    public static void main(String[] args) {
        System.out.println(new ChangeCoin().coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        return getChange(coins, amount, coins.length -1);

    }

    public int getChange(int[] coins, int amount, int index) {
        if(amount == 0 ){
            return 0;
        }

        if(index < 0){
            return amount + 1;
        }
        int change = amount/coins[index];
        int rem = amount % coins[index];

        return Math.min(change + getChange(coins, rem, index-1), getChange(coins, amount, index-1));
    }
}
