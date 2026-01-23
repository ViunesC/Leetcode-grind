package Hard;

public class q123 {
    public static int maxProfit(int[] prices) {
        // dp[i][0]: 1st transaction, buy stock on day i
        // dp[i][1]: 1st transaction, sell stock on day i
        // dp[i][2]: 2nd transaction, buy stock on day i
        // dp[i][3]: 2nd transaction, sell stock on day i
        int[][] dp = new int[prices.length][4];

        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0]; // 2nd buy = -1st buy + 1st sell - 2nd buy = -prices[0]
        for (int i=1;i<prices.length;++i) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] + prices[i]);
        }

        return dp[dp.length-1][3];
    }

    public static void testSample() {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
