package Easy;

public class q746 {
    public static int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length+1];

        for (int i=0;i<minCosts.length;++i) {
            if (i==0 || i==1)
                minCosts[i] = 0;
            else
                minCosts[i] = Math.min(minCosts[i-1] + cost[i-1], minCosts[i-2] + cost[i-2]);
        }

        return minCosts[minCosts.length-1];
    }

    public static void testSample() {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
