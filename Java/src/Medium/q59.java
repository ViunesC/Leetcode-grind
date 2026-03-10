package Medium;

import java.util.Arrays;

public class q59 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int p_x = 0, p_y = 0;
        int offset = 1;
        int r,c;
        int i = 1;
        int val = 1;

        while (i <= n / 2) {
            // Filling top side
            for (c=p_y;c<n-offset;++c)
                result[p_x][c] = val++;

            // Filling right side
            for (r=p_x;r<n-offset;++r)
                result[r][c] = val++;

            // Filling bottom side
            for (;c>p_y;--c)
                result[r][c] = val++;

            // Filling left side
            for (;r>p_x;--r)
                result[r][p_y] = val++;

            offset++;
            p_x++;
            p_y++;
            i++;
        }
        if (n % 2 == 1)
            result[p_x][p_y] = val;

        return result;
    }

    public static void testSample() {
        System.out.println("Final:");
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

}
