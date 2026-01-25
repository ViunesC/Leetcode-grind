package Medium;

public class q1035 {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        // same as finding the longest common subsequence
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        int result = 0;
        for (int i=1;i<=nums1.length;++i) {
            for (int j=1;j<=nums2.length;++j) {
                if (nums1[i-1] == nums2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);

                result = Math.max(dp[i][j], result);
            }
        }

        return result;
    }

    public static void testSample() {
        System.out.println(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
    }
}
