package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q503 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(ans, -1);

        for (int i=0;i<2*n;++i) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                ans[stack.pop()] = nums[i % n];
            stack.push(i % n);
        }

        return ans;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }
}
