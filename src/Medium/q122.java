package Medium;

public class q122 {
    public static int maxProfit(int[] prices) {
        // we scrap profit of entire period into every day
        // where each day's profit is today's stock price - previous day's stock price. First day has no profit
        // (only starts on 2nd day, as we cannot sell on 1st day)
        //
        // then, we only collect all the positive profit, which is the local optimum (+ daily profit)
        // the interval we got is the global optimum solution (time to buy/sell stock)
        int maxProfit = 0;

        int[] dailyProfit = new int[prices.length-1];
        for (int i=0;i<prices.length-1;++i) {
            dailyProfit[i] = prices[i+1] - prices[i];
        }

        for (int e : dailyProfit) {
            maxProfit = (e > 0) ? maxProfit + e : maxProfit;
        }

        return maxProfit;
    }

    public static void testSample() {
        System.out.println(maxProfit(new int[]{7}));
    }
}
