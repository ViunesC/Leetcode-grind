package Easy;

import java.util.*;

public class q496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0;i<nums1.length;++i) {
            map.put(nums1[i], i);
        }

        int p;
        for (int j=0;j<nums2.length;++j) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[j]) {
                p = map.getOrDefault(nums2[stack.pop()], -1);
                if (p != -1) {
                    ans[p] = nums2[j];
                }
            }

            stack.push(j);
        }

        return ans;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
