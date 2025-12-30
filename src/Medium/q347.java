package Medium;

import java.util.*;

/**
 * Leetcode 347: Top k frequent element
 * @author Viunec
 */
public class q347 {
    private static class F_tuple implements Comparable<F_tuple> {
        int element;
        int frequency;

        F_tuple(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(F_tuple o) {
            if (this.frequency > o.frequency)
                return 1;
            else if (this.frequency < o.frequency)
                return -1;

            return 0;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        Queue<F_tuple> queue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            queue.add(new F_tuple(key, map.get(key)));
        }

        for (int i=queue.size();i>k;i--)
            queue.poll();

        int[] results = new int[k];
        for (int i=0;i<k;i++) {
            results[i] = queue.poll().element;
        }

        return results;
    }

    public static void testSample() {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
