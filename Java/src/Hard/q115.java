package Hard;

public class q115 {
    public static int numDistinct(String s, String t) {
        // dp[i][j]: number of distinct subsequences of s[0.. i-1] which equals to t[0...j-1]
        // dp[i][0]: number of distinct ways to remove char in s s.t. it produce empty string, which is 1 (remove all chars)
        // dp[0][i]: number of distinct ways to remove char in empty string, s.t. it produce t[0..i-1], which is 0 (impossible)
        // if s[i-1] = t[j-1], then we have a match, we want to consider dp[i][j] to be the sum of considering i-1,j-1 and not considering them
        // e.g. s:bagg, t:bag, when we reached the second 'g', we either take it, or not take it (using previous g)
        // thus dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        // if s[i-1] != t[j-1], then we need to discard s, then dp[i][j] = dp[i-1][j]
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i=0;i<s.length();++i)
            dp[i][0] = 1;

        for (int i=1;i<=s.length();++i) {
            for (int j=1;j<=t.length();++j) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[s.length()][t.length()];
    }

    public static void testSample() {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
