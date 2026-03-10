package Easy;

import java.util.Arrays;

public class q977 {
    // Two pointer
    public static int[] sortedSquares(int[] nums) {
        int i=0, j=nums.length-1;
        int[] result = new int[nums.length];

        for (int k=nums.length-1;k>=0;--k) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k] = nums[i] * nums[i];

                ++i;
            } else {
                result[k] = nums[j] * nums[j];

                --j;
            }
        }

        return result;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}
