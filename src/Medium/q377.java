package Medium;


public class q377 {
    private static int result = 0;

    public static int combinationSum4(int[] nums, int target) {
        // backtracking method (will exceed time limit)
        // backTrack(0,nums,target);
        // return result;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    private static void backTrack(int start, int[] nums, int remaining) {
        if (remaining == 0) {
            result++;
            return;
        }

        for (int i=start;i<nums.length;++i) {
            if (nums[i] <= remaining)
                backTrack(start, nums, remaining-nums[i]);
        }
    }

    public static void testSample() {
        System.out.println(combinationSum4(new int[]{2,1,3}, 35));
    }
}
