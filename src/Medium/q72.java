package Medium;

public class q72 {
    public static int minDistance(String word1, String word2) {
        // dp[i][j]: min. operation required to modify w1[0...i-1] and w2[0...j-1] to make them same
        // if i and j points to same char, then dp[i][j] = dp[i-1][j-1]
        // otherwise we need to check three opeartions, and choose the smallest among them
        // 1. remove one in w1
        // 2. remove one in w2
        // 3. swap one in w1/w2
        // Note: add one in w1 is effective same as remove one in w2, as they have the same number of operations
        // e.g. acd, ad => add c in w2 == remove c in w1, thus we will not consider add separately, as they are included already
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        // initialization: for dp[i][0] or dp[0][j], we remove all chars in i/j to match an empty string
        for (int i=0;i<=word1.length();++i)
            dp[i][0] = i;
        for (int j=0;j<=word2.length();++j)
            dp[0][j] = j;

        for (int i=1;i<=word1.length();++i) {
            for (int j=1;j<=word2.length();++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void testSample() {
        System.out.println(minDistance("intention", "execution"));
    }
}
