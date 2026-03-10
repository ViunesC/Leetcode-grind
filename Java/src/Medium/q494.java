package Medium;

public class q494 {
    public static int findTargetSumWays(int[] nums, int target) {
        // if x is sum of all added integer, sum(nums) - x is the sum of all subtracted integers
        // then x - (sum - x) = target is what we need
        // x + x - sum = target
        // 2x = target + sum
        // x = (target + sum) / 2
        // if x is not an integer (with decimal), or sum of all integer is smaller than target
        // then there will be no way to assign such that result = target
        // -> the problem becomes: how many ways we can fill a bag of size x with given nums[1...i]?
        // for dp[i][j] it represent the maximum number of ways to fill a bag of size j(or below) given element 0...i

        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        if (Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 == 1) return 0;

        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagSize];
    }

    public static void testSample() {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
