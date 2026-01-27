package Medium;

public class q516 {
    public static int longestPalindromeSubseq(String s) {
        // dp[i][j]: len of longest palindrome subsequence in s[i,j]
        // if s[i] == s[j], then i(leftbound) and j(rightbound) can form a palindrome (with something in between), then dp[i][j] = dp[i + 1][j - 1] + 2
        // otherwise, we pick the max outcome between choosing s[i] or s[j]

        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void testSample() {

    }
}
