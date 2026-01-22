package Medium;

public class q122 {
//    public static int maxProfit(int[] prices) {
//        // Greedy solution
//        // we scrap profit of entire period into every day
//        // where each day's profit is today's stock price - previous day's stock price. First day has no profit
//        // (only starts on 2nd day, as we cannot sell on 1st day)
//        //
//        // then, we only collect all the positive profit, which is the local optimum (+ daily profit)
//        // the interval we got is the global optimum solution (time to buy/sell stock)
//        int maxProfit = 0;
//
//        int[] dailyProfit = new int[prices.length-1];
//        for (int i=0;i<prices.length-1;++i) {
//            dailyProfit[i] = prices[i+1] - prices[i];
//        }
//
//        for (int e : dailyProfit) {
//            maxProfit = (e > 0) ? maxProfit + e : maxProfit;
//        }
//
//        return maxProfit;
//    }
    public static int maxProfit(int[] prices) {
        // dp[i][0]: max profit on day i assuming there are stocks in hand
        // dp[i][1]: max profit on day i assuming there are no stocks in hand
        // dp[i][0] = max (have stock in hand since i-1, sold stock on i-1 and bought on day i)
        // dp[i][1] = max (no stock in hand since i-1, sold stock on day i)
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i=1;i<prices.length;++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
    }

    public static void testSample() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
