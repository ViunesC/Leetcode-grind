package Medium;

import java.util.Arrays;

public class q416 {
    public static boolean canPartition(int[] nums) {
        int target = 0;
        for (int e : nums)
            target += e;
        if (target % 2 != 0)
            return false;

        target /= 2;

        int[] baggableSum = new int[target+1];

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                baggableSum[j] = Math.max(baggableSum[j], baggableSum[j - num] + num);
            }

            if (baggableSum[target] == target)
                return true;
        }

        System.out.println(Arrays.toString(baggableSum));
        return baggableSum[target] == target;
    }

    public static void testSample() {
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }
}
