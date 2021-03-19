package practice;

import java.util.HashMap;
import java.util.Map;

public class ModifiedFrogJump {
    public static void main(String[] args) {
        int[] jumpValues = new int[]{1, 2, 0, 4, 0};
        Map<Integer, Boolean>  memoMap = new HashMap<>();

        System.out.println(canFrogJumpTillEnd(jumpValues, 0, memoMap));
    }

    static boolean canFrogJumpTillEnd(int[] jumpValues, int index, Map<Integer, Boolean> memoMap){
        Boolean inMemo = memoMap.get(index);
        if(inMemo != null){
            return inMemo;
        }

        for(int i = 1; i <= jumpValues.length; i++){
            if(canFrogJumpTillEnd(jumpValues, index + i, memoMap)){
                memoMap.put(index, true);
                return true;
            }
        }

        memoMap.put(index,  index == jumpValues.length - 1);
        return  index == jumpValues.length - 1;
//        if (jumpValues.length <= index) {
//            return false;
//        }
//
//        if (index == jumpValues.length - 1) {
//            return true;
//        }
//
//       for (int i=1; i<=jumpValues[index]; i++) {
//           if (canFrogJumpTillEnd(jumpValues, index+i)) {
//               return true;
//           }
//       }
//
//       return false;
    }
}
