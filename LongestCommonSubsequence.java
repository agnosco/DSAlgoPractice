package practice;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("aaba", "acabaca"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] tmp2dArray = new int[text1.length()][text2.length()];
        return longest(text1, text2, text1.length(), text2.length());
    }

    public static int longest(String text1, String text2, int pos1, int pos2){

        if(pos1 == 0 || pos2 == 0){
            return 0;
        }

        if(text1.charAt(pos1-1) == text2.charAt(pos2-1)){
            return longest(text1, text2, pos1 -1, pos2 -1) + 1;
        }else{
            return Math.max(longest(text1, text2, pos1, pos2 -1), longest(text1, text2, pos1 -1, pos2));
        }
    }
}
