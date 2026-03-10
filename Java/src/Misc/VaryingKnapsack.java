package Misc;

public class VaryingKnapsack {

    /**
     * Varying Knapsack
     * <p>
     * Given bag size and a list of item, each with its own weight, value and number of items
     * return the maximum value obtainable given the bag size (allowable weight)
     *
     * @param size maximum weight that bag can hold
     * @param weights list of weights
     * @param values list of values
     * @param nums list of numbers of each item
     * @return maximum value obtainable
     */
    public static int maxValue(int size, int[] weights, int[] values, int[] nums) {
        int[] dp = new int[size+1];

        for (int i=0;i<weights.length;++i) {
            for (int j=size;j>=weights[i];--j) {
                for (int k=1;k<=nums[i] && k*weights[i] <= j;++k) {
                    // for each item, check the result of k numbers of item being putted in bag
                    dp[j] = Math.max(dp[j], dp[j-(k*weights[i])] + k*values[i]);
                }
            }
        }

        return dp[size];
    }

    public static void testSample() {
        System.out.println(maxValue(10, new int[]{1,3,4}, new int[]{15,20,30}, new int[]{2,3,2}));
    }
}
