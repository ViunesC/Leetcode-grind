package Hard;

public class q188 {
    public static int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][k*2];

        for (int i=0;i<k*2;i+=2) {
            dp[0][i] = -prices[0];
        }

        for (int i=1;i<prices.length;++i) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);

            for (int j=1;j<k*2;++j) {
                if (j % 2 != 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + prices[i]);
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - prices[i]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void testSample() {
        System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
