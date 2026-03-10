package Easy;

import java.util.Arrays;

public class q283 {
    public static void moveZeroes(int[] nums) {
        // we define two pointers: slow vs. fast
        // initially slow points to same element as fast
        // when we encountered a zero, fast move forward while slow remains same
        // until fast hit a non-zero, we will replace what slow points to, to what fast points to
        // then move slow forward
        // everytime we swap the element that slow and fast points to
        // when fast reaches the end, all the remaining (eg. element and elements after slow) should be replaced by 0

        int slow=0;

        for (int fast=0;fast<nums.length;++fast) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i=slow;i<nums.length;++i) {
            nums[i] = 0;
        }
    }

    public static void testSample() {
        int[] arr = {0,1,0,3,12};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));
    }
}
