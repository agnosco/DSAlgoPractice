package practice;

public class TallestBillboard {

    static int NINF = Integer.MIN_VALUE /3 ;
    static Integer[][] memo;
    public static void main(String[] args) {

            int[] rods = new int[]{5,2,3,1, 6,4};
            int N = rods.length;
            memo = new Integer[N][10001];

        System.out.println( dbBillboard(rods, 0, 5000));
    }

    public static int dbBillboard(int[] rods, int i, int s ){

        if(rods.length ==  i ){
            return s == 5000 ? 0 : NINF;
        } else if(memo[i][s] != null){
            return memo[i][s];
        }else{
            int ans = dbBillboard(rods, i+1, s);
            ans = Math.max(ans, dbBillboard(rods, i+1, s - rods[i] ));
            ans = Math.max(ans, rods[i] + dbBillboard(rods, i+1, s+rods[i]));
            memo[i][s] = ans;
            return ans;
        }
    }
}





