package Easy;

public class q724 {

    public static int pivotIndex(int[] nums) {
//        brute-force solution: O(n^2)
//        int leftSums, rightSums;
//        for (int i=0;i<nums.length;++i) {
//            if (i == 0)
//                leftSums = 0;
//            else
//                leftSums = calculateSum(nums, 0, i);
//
//            if (i == nums.length-1)
//                rightSums = 0;
//            else
//                rightSums = calculateSum(nums, i+1, nums.length);
//
//            if (leftSums == rightSums)
//                return i;
//        }
//
//        return -1;
        int totalSum = calculateSum(nums, 0, nums.length);
        int leftSum, rightSum;
        for (int i=0;i<nums.length;++i) {
            leftSum = calculateSum(nums,0, i);
            rightSum = totalSum - leftSum - nums[i];
            // System.out.println(leftSum + " " + rightSum + " " + totalSum);

            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }

    /**
     * Calculate subarray sum from start (inclusive) to end (exclusive)
     * @param nums given array
     * @param start start index
     * @param end end index
     * @return sum in integer
     */
    private static int calculateSum(int[] nums, int start, int end) {
        if (end == 0)
            return 0;

        int sum = 0;
        for (int i=start;i<end;++i)
            sum += nums[i];

        return sum;
    }

    public static void testSample() {
        System.out.println(pivotIndex(new int[]{4}));
    }
}
