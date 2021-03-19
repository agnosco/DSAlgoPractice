package practice;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class GenerateValidIP {
    public static void main(String[] args) {
        System.out.println(generateIp("55551135", 1, new ArrayList<>(), 0));
    }

    public static List<String> generateIp(String S, int index, List<String> stringList, int dots){
        if(dots >= 3 || index >= S.length() ){
            if(Integer.parseInt(S.substring(index,S.length() ))  <= 255) {
                stringList.add(S);
            }
            return stringList;
        }


        if(Integer.parseInt(S.substring(index, index +1 ))  <= 255){
            String s1 = S.substring(0, index ) + "." + S.substring(index, S.length());
            generateIp(s1, index + 2, stringList, dots+1  );

        }
        if(Integer.parseInt(S.substring(index, index +2 ))  <= 255){
            String s2 =  S.substring(0, index +1) + "." + S.substring(index + 1, S.length());
            generateIp(s2, index + 3, stringList, dots+1  ) ;
        }
        if(Integer.parseInt(S.substring(index, index  + 3))  <= 255){
            String s3 =  S.substring(0, index +2) + "." + S.substring(index + 2, S.length());
            if(index + 4 < S.length())
                generateIp(s3, index + 4, stringList, dots+1 );
        }

                return stringList;
    }

    public  boolean isValidIP(){

        return  false;
    }
}
