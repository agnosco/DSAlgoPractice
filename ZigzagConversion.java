package practice;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert( "PAYPALISHIRING", 3));
    }

    public static  String convert(String s, int numRows) {

        List<StringBuilder> sbList = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            sbList.add(new StringBuilder());
        }
        boolean down = true;
        int sbIndex = 0;
        for(int i = 0; i < s.length(); i++){
            sbList.get(sbIndex).append(s.charAt(i));
            if(sbIndex >= numRows -1){
                down = false;
            }else if (sbIndex == 0){
                down = true;
            }
            sbIndex = down ? sbIndex + 1 : sbIndex - 1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : sbList) ret.append(row);
        return ret.toString();
    }
}
