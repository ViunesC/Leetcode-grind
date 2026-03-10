package Medium;

public class q714 {
    public static int maxProfit(int[] prices, int fee) {
        // dp[i][0]: on day i, hold stock, either bought on day i, or hold until day i
        // dp[i][1]: on day i, not holding stock, either sold on day i, or sold before day i
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];

        for (int i=1;i<prices.length;++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }

    public static void testSample() {
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
    }
}
