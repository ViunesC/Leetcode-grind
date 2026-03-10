package Medium;

public class q1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] = the longest common subsequence in text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        int result = 0;
        for (int i=1;i<=text1.length();++i) {
            for (int j=1;j<=text2.length();++j) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    // if two pointers i,j points to same character
                    // we will increment length count, by adding to result of previous (i-1,j-1)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    // if i,j points to different character
                    // we will find the max common length when excluding i or j
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);

                if (dp[i][j] > result) result = dp[i][j];
            }
        }

        return result;
    }

    public static void testSample() {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
