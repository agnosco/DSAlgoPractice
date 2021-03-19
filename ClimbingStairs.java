package practice;

public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n){

        if(n <= 2){
            return n;
        }

        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairsdp(int a) {
        if(a ==0){
            return 0;
        }
        if(a ==1){
            return 1;
        }
        int cache[] = new int [a] ;
        cache[0] = 1;
        cache[1] = 2;
        for(int i = 2 ; i < a ; i++){
            cache[i] = cache[i - 1] + cache[i - 2];
            Math.abs(cache[i] - 3);

        }
        return cache[a-1];

    }

}
