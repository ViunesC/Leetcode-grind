package Medium;

public class q322 {
    public static int coinChange(int[] coins, int amount) {
        int[] changes = new int[amount+1];

        // since for amount=0 there are 0 ways to fill the amount
        changes[0] = 0;

        for (int i=1;i<changes.length;++i)
            // we want to have minimum value for each change[i]
            // therefore we initialize each entry with maximum value
            changes[i] = Integer.MAX_VALUE;

        for (int i=0;i<coins.length;++i) {
            for (int j=coins[i];j<=amount;++j) {
                if (changes[j - coins[i]] != Integer.MAX_VALUE)
                    changes[j] = Math.min(changes[j], changes[j-coins[i]]+1);
            }
        }

        if (changes[changes.length-1] == Integer.MAX_VALUE)
            return -1;

        return changes[changes.length-1];
    }

    public static void testSample() {
        System.out.println(coinChange(new int[]{3}, 10));
    }
}
