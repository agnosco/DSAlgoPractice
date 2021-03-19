package practice;

public class SumTwoPoiter {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] twoSum(int[] numbers, int target) {

        int sum = numbers[0];
        int p1 = 0;
        int p2 = numbers.length - 1;
        int[] output = new int[2];
        while (p1 != p2) {
            sum = numbers[p1] + numbers[p2];
            if (sum == target) {
                output[0] = p1;
                output[1] = p2;
                break;
            } else if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }

        return output;

    }
}
