package practice;


//A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//
//        Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
//
//        If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
//
//        Note:
//
//        The number of stones is ≥ 2 and is < 1,100.
//        Each stone's position will be a non-negative integer < 231.
//        The first stone's position is always 0.
//        Example 1:


import java.util.HashMap;
import java.util.Map;

public class FrogCrossRiver {
    public static class Pair<T, E>{
        T t;
        E e;
        Pair(T t, E e){
            this.t = t;
            this.e = e;
        }
    }
    public static void main(String[] args) {
        int[] stones = new int[]{0, 1, 3, 4, 5, 8};
        Map<String, Boolean> memoMap = new HashMap<>();
        System.out.println(canJumpNextStone(stones, 0, 0, memoMap));
    }


    public static boolean canJumpNextStone(int[] stones, int index, int lastJumpUnit, Map<String, Boolean> memoMap ) {

        Boolean inMemo = memoMap.get(index + "," + lastJumpUnit);
        if(inMemo != null){
            return inMemo;
        }

        for (int i = index + 1; i < stones.length; i++) {
            int jump = stones[i] - stones[index];
            if (Math.abs(jump - lastJumpUnit) <= 1) {
                if (canJumpNextStone(stones, i, jump, memoMap)) {
                    memoMap.put(index + "," + lastJumpUnit, true);
                    return true;
                }
            } else if (jump - lastJumpUnit > 1) {
                memoMap.put(index + "," + lastJumpUnit, false);
                return false;
            }

        }

        memoMap.put(index + "," + lastJumpUnit, index == stones.length - 1);
        return index == stones.length - 1;
    }

}
