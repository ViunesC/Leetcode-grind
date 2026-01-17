package Medium;

public class q518 {
    public static int change(int amount, int[] coins) {
        int[][] combPerAmount = new int[coins.length][amount+1];

        for (int i=0;i<=amount;++i) {
            if (i % coins[0] == 0) combPerAmount[0][i] = 1;
        }

        combPerAmount[0][0] = 1;

        for (int i=1;i<coins.length;++i) {
            for (int j=0;j<amount+1;++j) {
                if (j == 0)
                    combPerAmount[i][j] = 1;
                else if (j < coins[i])
                    combPerAmount[i][j] = combPerAmount[i-1][j];
                else
                    combPerAmount[i][j] = combPerAmount[i-1][j] + combPerAmount[i][j-coins[i]];
            }
        }

        return combPerAmount[combPerAmount.length-1][combPerAmount[0].length-1];
    }

    public static void testSample() {
        System.out.println(change(3, new int[]{2}));
    }
}
