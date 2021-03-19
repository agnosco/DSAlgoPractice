package practice;

import java.util.HashMap;
import java.util.Map;

//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
public class FiboTest {
    public static void main(String[] args) {

        System.out.println( new FiboTest().fibo(6));
//        String s = "leetCode";
//        int index = -1;
//        int[] nums = new int[3];
////        nums.length
//        Map<Character, Integer> charCountMap = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            int j = charCountMap.getOrDefault(s.charAt(i), 0);
//            j++;
//            charCountMap.put(s.charAt(i), j);
//        }
//
//        for(int i = 0; i < s.length(); i++){
//            if(charCountMap.get(s.charAt(i))  == 1){
//                index = i;
//                break;
//            }
//        }


    }

    private static Object fibo(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n-1];
    }
//
//
//    public static ArrayList<String> popularNToys(int numToys,
//                                                 int topToys,
//                                                 List<String> toys,
//                                                 int numQuotes,
//                                                 List<String> quotes)
//    {
//        // WRITE YOUR CODE HERE
//        Map<String, Integer> toysMap = new HashMap<>();
//        for(String toy : toys){
//            toysMap.put(toy, 0);
//        }
//
//        for(String quote : quotes){
//            for(String toy : toys){
//                if(quote.toLowerCase().contains(toy.toLowerCase())){
//                    toysMap.get(toy);
//                }
//            }
//
//        }
//    }
//    public static void main(String[] args) {
//    }
//
//    public static int fibor(int n){
//        if(n == 1 || n == 2){
//            return 1;
//        }
//        return  fibor(n-1)  + fibor(n-2);
//    }
//
//    public  static int fibom(int n){
//        if(n == 1 || n == 2){
//            return 1;
//        }
//
//
//
//        if(fibos[n] != 0){
//            return fibos[n];
//        }
//        fibos[n] =   fibor(n-1)  + fibor(n-2);
//
//        return fibos[n];
//    }
//    static int[] fibos = new int[7];
//    public static int fiboD(int n){
//       fibos[1] = 1;
//       fibos[2] = 1;
//
//        for (int i = 3; i <= n; i ++){
//            fibos[i] = fibos[i-1] + fibos[i-2];
//        }
//
//        return fibos[n];
//    }
}



