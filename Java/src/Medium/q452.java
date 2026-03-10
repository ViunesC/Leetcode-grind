package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class q452 {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int result = 1;
        for (int i=1;i<points.length;++i) {
            if (points[i][0] > points[i-1][1])
                result++;
            else
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
        }

        return result;
    }

    public static void testSample() {
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}
