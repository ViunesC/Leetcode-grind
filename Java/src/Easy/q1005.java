package Easy;

import java.util.Arrays;

public class q1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i=0;i<nums.length;++i) {
            if (nums[i] >= 0 || k == 0) break;
            nums[i] = -nums[i];
            k--;
        }

        if (k > 0) {
            Arrays.sort(nums);

            while (k > 0) {
                nums[0] = -nums[0];
                k--;
            }
        }

        int maxSum = 0;
        for (int e : nums) {
            maxSum += e;
        }

        return maxSum;
    }

    public static void testSample() {
        System.out.println(largestSumAfterKNegations(new int[]{3,-1,0,2}, 3));
    }
}
