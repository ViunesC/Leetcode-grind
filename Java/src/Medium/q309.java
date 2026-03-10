package Medium;

public class q309 {
    public static int maxProfit(int[] prices) {
        // dp[i][0] = max profit on day i, hold stock on day i = max(bought before day i and hold = remain same, bought on day i,
        // i-1 is cooldown day and bought on day i)
        // dp[i][1] = max profit on day i, sold stock before day i = max(sold before day i-2 = remain same, sold on day i-2 = cooldown on i-1)
        // dp[i][2] = max profit on day i, sold stock on day i = i-1 just bought
        // dp[i][3] = max profit on day i, cooldown day = i-1 just sold

        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];

        for (int i=1;i<prices.length;++i) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1] - prices[i]), dp[i-1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }

        return Math.max(dp[dp.length-1][1],Math.max(dp[dp.length-1][2],dp[dp.length-1][3]));
    }

    public static void testSample() {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
