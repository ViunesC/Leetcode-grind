package Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 239: Sliding Window Maximum
 * @author Viunec
 */
public class q239 {
    private static class monoque {
        private List<Integer> q;

        monoque() {
            q = new ArrayList<>();
        }

        void pop(int x) {
            // pop only when element removed by sliding window
            // = element at the front of queue
            if (!q.isEmpty() && x == q.get(0)) {
                q.remove(0);
            }
        }

        void push(int x) {
            // remove the back element if x is greater than this element
            while (!q.isEmpty() && x > q.get(q.size()-1)) {
                q.remove(q.size()-1);
            }

            q.add(x);
        }

        int front() {
            if (!q.isEmpty())
                return q.get(0);
            else
                return -1;
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        monoque mq = new monoque();
        List<Integer> results = new ArrayList<>();

        for (int i=0;i<k;i++) {
            mq.push(nums[i]);
        }
        for (int j=k;j<nums.length;j++) {
            results.add(mq.front());
            mq.pop(nums[j-k]);
            mq.push(nums[j]);
        }
        results.add(mq.front());

        int[] arr = new int[results.size()];
        for (int i=0;i<results.size();i++) {
            arr[i] = results.get(i);
        }

        return arr;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
