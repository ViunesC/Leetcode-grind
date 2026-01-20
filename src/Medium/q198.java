package Medium;

public class q198 {
    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

// backtrack (time limit exceeded)
//        return robFrom(0, nums);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i=2;i<dp.length;++i) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }

//    private static int robFrom(int start, int[] nums) {
//        if (start == nums.length-2)
//            return Math.max(nums[start], nums[start+1]);
//        else if (start == nums.length-1)
//            return nums[start];
//
//        return Math.max(robFrom(start+2, nums) + nums[start], robFrom(start+1, nums));
//    }

    public static void testSample() {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
