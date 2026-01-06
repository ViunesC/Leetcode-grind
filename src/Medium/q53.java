package Medium;

public class q53 {
    public static int maxSubArray(int[] nums) {
        // if sum reaches negative number then discard and pick next as start
        // as negative number only decrease the overall sum

        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i=0;i<nums.length;++i) {
            count += nums[i];
            result = Math.max(count, result);
            if (count < 0) count = 0;
        }

        return result;
    }

    public static void testSample() {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
