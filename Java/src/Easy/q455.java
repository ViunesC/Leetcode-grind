package Easy;

import java.util.Arrays;

public class q455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // O(nlogn)
        Arrays.sort(s); // O(mlogn)

        int i=0,j=0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }

            j++;
        }

        return count;
    }

    public static void testSample() {
        System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,2,3}));
    }
}
