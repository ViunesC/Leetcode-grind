package Medium;

public class q376 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 2 && nums[0] != nums[1])
            return 2;

        int prevdiff=0, currdiff, result=1;
        for (int i = 0;i<nums.length-1;++i) {
            currdiff = nums[i+1] - nums[i];

            // if wiggle occurs
            if ((prevdiff <= 0 && currdiff > 0)||(prevdiff >= 0 && currdiff < 0)) {
                result++;

                prevdiff = currdiff;
            }
        }

        return result;
    }

    public static void testSample() {
        System.out.println(wiggleMaxLength(new int[]{1,2,2,2,3,4}));
    }
}
