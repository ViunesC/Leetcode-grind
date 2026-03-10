package Easy;

import java.util.Arrays;

public class q922 {
    public static int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 0, evenIndex = 0;
        int[] oddNums = new int[nums.length / 2];
        int[] evenNums = new int[nums.length / 2];

        for (int i=0;i<nums.length;++i) {
            if (nums[i] % 2 == 0)
                evenNums[evenIndex++] = nums[i];
            else
                oddNums[oddIndex++] = nums[i];
        }

        int index = 0;
        for (int i=0;i<evenNums.length;++i) {
            nums[index++] = evenNums[i];
            nums[index++] = oddNums[i];
        }

        return nums;
    }


    public static void testSample() {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4,2,5,7})));
    }
}
