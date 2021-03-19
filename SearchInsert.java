package practice;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(getIndex(nums, 5));
    }

    public static int getIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (start + end) / 2;


        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid] && mid + 1 < nums.length && target > nums[mid + 1] ) {
                return mid + 1;
            } else if (target > nums[mid] && mid - 1 >= 0 && target < nums[mid - 1] ) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return mid;
    }
}
