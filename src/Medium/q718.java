package Medium;

public class q718 {
    public static int findLength(int[] nums1, int[] nums2) {
        // dp[i][j]: max length of common subarray in A[0...i-1] and B[0...j-1]
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        int result = 0;
        for (int i=1;i<=nums1.length;++i) {
            for (int j=1;j<=nums2.length;++j) {
                if (nums1[i-1] == nums2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;

                if (dp[i][j] > result) result = dp[i][j];
            }
        }

        return result;
    }

    public static void testSample() {
        System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
