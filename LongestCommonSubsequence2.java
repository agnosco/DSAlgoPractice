package practice;

public class LongestCommonSubsequence2 {
    public static void main(String[] args) {
        String[] strs = new String[]{"car", "cir"};
        String s = strs[0];
        System.out.println( getPRefix(strs, 0, s));
    }

    public static String getPRefix(String[] strs, int index, String prefix){
        int minlength = strs[index].length() < prefix.length() ? strs[index].length() : prefix.length();
        int newPrefixLength = 0;
        for(int i = 0; i < minlength; i++){
            if(strs[index].charAt(i) == prefix.charAt(i)){
                newPrefixLength ++;
            }else {
                break;
            }
        }
        if(newPrefixLength > 0 && strs.length > index + 1){
           return  getPRefix(strs, index+1, prefix.substring(0, newPrefixLength));
        }else{
            return  prefix.substring(0, newPrefixLength);
        }
    }
}
