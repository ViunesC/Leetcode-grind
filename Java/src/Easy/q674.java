package Easy;

import java.util.Arrays;

public class q674 {
    public static int findLengthOfLCIS(int[] nums) {
        // since we were to find continuous subsequence
        // we only need 1 for-loop
        // dp[i]: length of longest continuous subsequence from 0 to i
        // where dp[i] = dp[i-1] + 1 if nums[i] > nums[i-1] (is a increasing subsequence)
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int result = 1;

        for (int i=1;i<nums.length;++i) {
            if (nums[i] > nums[i-1])
                dp[i] = dp[i-1] + 1;
            if (dp[i] > result) result = dp[i];
        }

        return result;
    }

    public static void testSample() {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
}
