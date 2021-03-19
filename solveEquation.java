package practice;

import java.util.ArrayList;
import java.util.List;

public class solveEquation {

    public static void main(String[] args) {
        new solveEquation().solve("2x+3x-6x+3=x+2");
    }

    private void solve(String s) {
        String lString = s.split("=")[0];
        String rString = s.split("=")[1];
        int lx = 0;

        int rx = 0;
        int lc = 0;
        int rc = 0;
        StringBuilder tempsb = new StringBuilder();


        int i = 0;
        int coe = 1;
        int tmpCoff = 0;
        while (i < lString.length()) {
            if (lString.charAt(i) == '+' || lString.charAt(i) == '-') {
                coe = lString.charAt(i) == '+' ? 1 : -1;
                lc += tmpCoff;
                tmpCoff = 0;
                i++;
            }

            if(lString.charAt(i) == 'x'){
                lx += coe *  tmpCoff;
                tmpCoff = 0;
                i++;
            }else{
                int j = 1;
                while(!lString.isEmpty() && Character.isDigit(lString.charAt(i))){
                    tmpCoff = tmpCoff + Integer.parseInt(String.valueOf(lString.charAt(i))) *  j;
                    j*=10;
                    i++;
                }
            }



        }

        System.out.println(lc);
        System.out.println(lx);

    }
}
