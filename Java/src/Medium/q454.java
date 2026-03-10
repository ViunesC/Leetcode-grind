package Medium;

import java.util.HashMap;
import java.util.Map;

public class q454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum1_2 = new HashMap<>();

        for (int n1 : nums1) {
            for (int n2: nums2) {
                if (sum1_2.containsKey(n1+n2))
                    sum1_2.put(n1+n2,sum1_2.get(n1+n2)+1);
                else
                    sum1_2.put(n1+n2, 1);
            }
        }

        int count = 0;

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                if (sum1_2.get(-(n3+n4)) != null) {
                    count += sum1_2.get(-(n3+n4));
                }
            }
        }

        return count;
    }

    public static void testSample() {
        int[] nums1 = new int[]{1,2}, nums2 = new int[]{-2,-1}, nums3 = new int[]{-1,2}, nums4 = new int[]{0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
