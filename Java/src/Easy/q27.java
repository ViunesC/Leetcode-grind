package Easy;

import java.util.Arrays;

public class q27 {
    // Two pointer
    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        int k = 0;

        while (fast < nums.length) {

            nums[slow] = nums[fast];

            if (nums[slow] != val) {
                ++k;
                ++slow;
            }
            ++fast;
        }

        return k;
    }

    public static void testSample() {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2) + ";" + Arrays.toString(nums));
    }
}
