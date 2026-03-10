package Medium;

import java.util.Arrays;

/**
 * Leetcode 34: Find first and last position of element in sorted array
 * @author Viunec
 */
public class q34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        if (nums.length == 0)
            return result;

        result[0] = findLeft(nums, target, 0, nums.length-1);
        result[1] = findRight(nums, target, 0, nums.length-1);

        return result;
    }

    private static int findLeft(int[] nums, int target, int left, int right) {
        if (left == right && nums[left] == target)
            return left;

        if (right - left == 1) {
            if (nums[left] == target)
                return left;

            if (nums[right] == target)
                return right;
        }

        if (left > right || left == right)
            return -1;

        int mid = (right - left) / 2 + left;

        if (target > nums[mid])
            return findLeft(nums, target, mid+1, right);

        if (target < nums[mid])
            return findLeft(nums, target, left, mid-1);

        return findLeft(nums, target, left, mid);
    }

    private static int findRight(int[] nums, int target, int left, int right) {
        if (left == right && nums[right] == target)
            return right;

        if ((right - left) == 1) {
            if (nums[right] == target)
                return right;

            if (nums[left] == target)
                return left;
        }

        if (left > right || left == right)
            return -1;

        int mid = (right - left) / 2 + left;

        if (target < nums[mid])
            return findRight(nums, target, left, mid-1);

        if (target > nums[mid])
            return findRight(nums, target, mid+1, right);

        return findRight(nums, target, mid, right);
    }

    public static void testSample() {
        int[] a1 = new int[]{1,2,3,3,3,3,4,5,9};
        int[] a2 = new int[]{5,7,7,8,8,10};

        System.out.println("Testing " + Arrays.toString(a1) + " w/ target = 3");
        System.out.println(Arrays.toString(q34.searchRange(a1, 3)));
        System.out.println("Testing " + Arrays.toString(a2) + " w/ target = 6");
        System.out.println(Arrays.toString(q34.searchRange(a1, 6)));
    }
}
