package Medium;

public class q53 {
    public static int maxSubArray(int[] nums) {
        // Greedy solution
        // if sum reaches negative number then discard and pick next as start
        // as negative number only decrease the overall sum

//        int result = Integer.MIN_VALUE;
//        int count = 0;
//        for (int i=0;i<nums.length;++i) {
//            count += nums[i];
//            result = Math.max(count, result);
//            if (count < 0) count = 0;
//        }
//
//        return result;
        // dp[i]: max sum using numbers from 0 to i
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];

        for (int i=1;i<nums.length;++i) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);

            if (dp[i] > result) result = dp[i];
        }

        return result;
    }

    public static void testSample() {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
