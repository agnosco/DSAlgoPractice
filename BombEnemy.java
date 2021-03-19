package practice;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BombEnemy {
    static Map<String, Boolean> rowMap = new HashMap<>();
    static Map<String, Boolean> colMap = new HashMap<>();
    public static void main(String[] args) {

        // Get the input matrix
        char [][]s = { "XXEX".toCharArray(),
                "XBXX".toCharArray(),
                "XEXX".toCharArray(),
                "XXBX".toCharArray() };


        System.out.println(checkIfEnemyCanbekilled(s));
    }

    private static boolean checkIfEnemyCanbekilled(char[][] s) {

        int row = s.length;
        int col = s[0].length;
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < s[0].length; j++){
                if(s[i][j] == 'E'){
                    return checkBombExistInRowOrCol(i, j, s);
                }
            }
        }

        return true;
    }

    public static  boolean checkBombExistInRowOrCol(int r, int c, char[][] s){
        if(rowMap.containsKey("R"+ r) || colMap.containsKey("C " + c)){
            return rowMap.get("R" + r) || colMap.get("C" + c);
        }

        populateMap(r, c, s);
        return rowMap.get("R" + r) || colMap.get("C" + c);
    }

    private static void populateMap(int r, int c, char[][] s) {

        for(int i = 0; i < s[0].length; i++){
            rowMap.put("R" + r, FALSE);
            if(s[r][i] == 'B'){
                rowMap.put("R" + r, TRUE);
                break;
            }
        }

        for(int j = 0; j < s.length; j++){
            colMap.put("C"+c, FALSE);
            if(s[j][c] == 'B'){
                colMap.put("C"+c, TRUE);
                break;
            }
        }
    }
}
