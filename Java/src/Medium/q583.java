package Medium;

public class q583 {
    public static int minDistance(String word1, String word2) {
        // dp[i][j]: min. number of steps to make word1[0...i-1][0...j-1] same
        // if w1[i-1] == w2[j-1], then dp[i][j] = dp[i-1][j-1] (min steps to get word without i-1,j-1)
        // else dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1: min. steps to get word, either removing i or j (one op)
        // dp[0][0]: 0
        // dp[0][j]: j
        // dp[i][0]: i
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i=0;i<=word1.length();++i)
            dp[i][0] = i;
        for (int j=0;j<=word2.length();++j)
            dp[0][j] = j;

        for (int i=1;i<=word1.length();++i) {
            for (int j=1;j<=word2.length();++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void testSample() {
        System.out.println(minDistance("leetcode", "etco"));
    }
}
