package Easy;

import java.util.Arrays;

public class q1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numSmaller = new int[101];

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        for (int i=1;i<sortedNums.length;++i) {
            if (sortedNums[i] == sortedNums[i-1])
                continue;

            numSmaller[sortedNums[i]] = i;
        }

        for (int i=0;i<nums.length;++i) {
            nums[i] = numSmaller[nums[i]];
        }

        return nums;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7,7,7,7})));
    }
}
