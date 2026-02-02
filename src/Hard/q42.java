package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class q42 {
    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        int result=0, h, w;
        for (int i=1;i<height.length;++i) {
            if (!stack.isEmpty() && height[i] == height[stack.peek()])
                stack.pop();

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // we found another boundary, pop and calculate the capacity
                int mid = stack.pop();

                if (!stack.isEmpty()) {
                    h = Math.min(height[i], height[stack.peek()]) - height[mid];
                    w = i - stack.peek() - 1;
                    result += h * w;
                }
            }
            stack.push(i);

            // System.out.println("top->" + stack);
        }

        return result;
    }

    public static void testSample() {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
