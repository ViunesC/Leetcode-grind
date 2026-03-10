package Medium;

import java.util.Arrays;

public class q1049 {
    public static int lastStoneWeightII(int[] stones) {
        // since a collision between x and y will get y-x
        // if we partition stones into two piles s.t. each pile have roughly same weight
        // then if we crush stones in two piles (with some order, we don't need to know), the result will be minimum
        // therefore we need to find a way to fill the bag with size sum/2 (roughly), then use
        // (sum - dp[target]) - dp[target] to find remaining weight (since target = sum /2 will always round down)
        int sum=0;
        for (int e : stones)
            sum += e;
        int target = sum / 2;
        int[] bag = new int[target+1];

        // System.out.println("SUM = " + sum + ", TARGET = " + target);
        // System.out.println("STONES: " + Arrays.toString(stones));

        for (int i=0;i<stones.length;++i) {
            for (int j=target;j>=stones[i];--j) {
                bag[j] = Math.max(bag[j], bag[j-stones[i]] + stones[i]);
            }

            // System.out.println("Item " + stones[i] + ": " + Arrays.toString(bag));
        }

        return (sum - bag[target]) - bag[target];
    }

    public static void testSample() {
        System.out.println(lastStoneWeightII(new int[]{2,7,4,1,8,1}));
    }
}
