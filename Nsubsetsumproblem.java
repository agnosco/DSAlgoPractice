package practice;

public class Nsubsetsumproblem {
    public static void main(String[] args) {

        System.out.println(hasSubsetSum(new int[]{2, 8, 5, 6}, 14, 0));
    }

    public static boolean hasSubsetSum(int[] subset, int target, int index) {
        if (index >= subset.length || target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        return hasSubsetSum(subset, target - subset[index], index + 1) || hasSubsetSum(subset, target, index + 1);


    }
}
