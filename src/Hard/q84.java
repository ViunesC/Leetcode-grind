package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class q84 {
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<Integer>();

        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        for (int i = 1; i < heights.length; i++) {
            if (!st.isEmpty() && heights[i] == heights[st.peek()]) {
                st.pop();
            }

            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int mid = st.pop();

                if (!st.isEmpty()) {
                    int left = st.peek();
                    int w = i - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
            }

            st.push(i);

        }
        return result;
    }

    public static void testSample() {

    }
}
