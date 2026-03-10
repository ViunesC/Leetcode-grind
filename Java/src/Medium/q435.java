package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class q435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        for (int i=1;i<intervals.length;++i) {
            if (intervals[i][0] < intervals[i-1][1]) {
                // overlapped, mark for deletion
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
            }
        }

        return count;
    }

    public static void testSample() {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
}
