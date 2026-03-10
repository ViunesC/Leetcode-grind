package Medium;

public class q55 {
    public static boolean canJump(int[] nums) {
        // we pick the maximum jump length each time to calculate *Largest jump area*
        // if the area eventually covers last element then it's reachable

        int maxTotalLength = 0;
        if (nums.length == 1) return true;

        for (int i=0;i<=maxTotalLength;++i) {
            maxTotalLength = Math.max(maxTotalLength, nums[i] + i);

            if (maxTotalLength >= nums.length - 1) return true;
        }

        return false;
    }

    public static void testSample() {
        System.out.println(canJump(new int[]{3,2,1,1,4}));
    }
}
