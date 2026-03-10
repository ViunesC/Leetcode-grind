package Medium;

public class q213 {
    public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        int a,b;

        // first run (start from first and ignore tailing)
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2;i<nums.length-1;++i) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        a = dp[nums.length-2];

        // second run (ignore first and covers tailing)
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i=3;i<nums.length;++i) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        b = dp[nums.length-1];

        return Math.max(a,b);
    }

    public static void testSample() {
        System.out.println(rob(new int[]{1,3,1}));
    }
}
