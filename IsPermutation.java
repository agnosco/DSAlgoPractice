package practice;

import java.util.Arrays;

public class IsPermutation {
    public static void main(String[] args) {
        String s = "abc";
        String p = "bac";

        new IsPermutation().isPermutation(s, p);


    }

    private boolean isPermutation(String s, String p) {
        if(s.length() != p.length()){
            return false;
        }

        Arrays.sort(s.toCharArray());
        Arrays.sort(p.toCharArray());

        return s == p;
    }
}
