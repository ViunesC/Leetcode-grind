package Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[temperatures.length];
        int j;
        for (int i=0;i<temperatures.length;++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }

        return result;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
