package Medium;

public class q209 {
    // Sliding Window
    public static int minSubArrayLen(int target, int[] nums) {
        int i=0, result = Integer.MAX_VALUE;
        int subLength = 0;
        int sum = 0;

        for (int j=0;j<nums.length;++j) {
            sum += nums[j];
            while (sum >= target) {
                subLength = (j-i) + 1;
                result = Math.min(result, subLength);
                sum -= nums[i++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void testSample() {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
