package Easy;

public class q121 {
    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i=0;i<prices.length;++i) {
            maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
            lowestPrice = Math.min(lowestPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void testSample() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
