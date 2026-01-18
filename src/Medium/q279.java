package Medium;

import java.util.Arrays;

public class q279 {
    public static int numSquares(int n) {
        int[] leastNumPerSize = new int[n+1];

        leastNumPerSize[0] = 0;
        for (int i=1;i<=n;++i)
            leastNumPerSize[i] = Integer.MAX_VALUE;

        for (int j=1;j<=n;++j) {
            // System.out.println(Arrays.toString(leastNumPerSize));
            for (int i=0;i*i<=j;++i) {
                if (leastNumPerSize[j-i*i] != Integer.MAX_VALUE)
                    leastNumPerSize[j] = Math.min(leastNumPerSize[j], leastNumPerSize[j-i*i]+1);
            }
        }

        return leastNumPerSize[n];
    }

    public static void testSample() {
        System.out.println(numSquares(13));
    }
}
