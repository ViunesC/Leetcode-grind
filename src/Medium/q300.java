package Medium;

import java.util.Arrays;

public class q300 {
    public static int lengthOfLIS(int[] nums) {
        // we shall have two needles, i and j
        // where i iterate through nums and j iterate through 0 to i
        // dp[i] is the max length of subsequence from nums[0] to nums[i]
        // which can be obtained by iteratively search longest subseqence in 0 to i, ending with j
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int result = 1;
        for (int i=1;i<nums.length;++i) {
            for (int j=0;j<i;++j) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }

            if (dp[i] > result) result = dp[i];
        }

        return result;
    }

    public static void testSample() {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
