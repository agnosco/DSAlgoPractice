package practice;

public class LongestPalindrome {

    public static void main(String[]args){
        System.out.println(getLongestPalindrome("ac"));
    }
    public static String getLongestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        int maxSub = 1;
        int start = 0;
        int end = 1;

        for(int i = 0; i < s.length(); i++){
            for(int j= i+1; j < s.length(); j++){
                if(isPalindrome(s, i, j) && maxSub < (j - i + 1) ){
                    maxSub = (j-i+1);
                    start = i;
                    end = j+1;
                }
            }
        }

        return s.substring(start, end);
    }

    public static boolean isPalindrome(String s, int i, int j){

        for(; i < j;  i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

}
