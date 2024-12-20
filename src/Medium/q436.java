package Medium;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Leetcode 436: Find Right Interval
 * @author Viunec
 */
public class q436 {
    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> startFirst = new TreeMap<>();

        for (int i=0;i<intervals.length;++i)
            startFirst.put(intervals[i][0],i);

        int[] result = new int[intervals.length];
        Integer next;

        for (int j=0;j<intervals.length;++j) {
            next = startFirst.ceilingKey(intervals[j][1]);
            result[j] = (next == null) ? -1 : startFirst.get(next);
        }

        return result;
    }

    public static void testSample() {
        int[][] test1 = new int[][]{{1,4},{2,3},{3,4}};
        int[][] test2 = new int[][]{{3,4},{2,3},{1,2}};
        int[][] test3 = new int[][]{{4,4}};

        System.out.println("Testing " + Arrays.deepToString(test1));
        System.out.println("Result:" + Arrays.toString(q436.findRightInterval(test1)));

        System.out.println("Testing " + Arrays.deepToString(test2));
        System.out.println("Result:" + Arrays.toString(q436.findRightInterval(test2)));

        System.out.println("Testing " + Arrays.deepToString(test3));
        System.out.println("Result:" + Arrays.toString(q436.findRightInterval(test3)));
    }
}
