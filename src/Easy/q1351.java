package Easy;

import java.util.Arrays;

/**
 * Leetcode 1351: Count Negative Numbers in a Sorted Matrix
 * @author Viunec
 */
public class q1351 {

    public static int countNegatives(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1 && grid[0][0] < 0)
            return 1;

        int result = 0;
        for (int i=0;i<grid.length;++i) {
            if (grid[i][grid[i].length-1] >= 0)
                continue;

            result += count1DUtil(grid[i],0, grid[i].length-1);
        }

        return result;
    }

    private static int count1DUtil(int[] grid_row, int left, int right) {
        if (left > right)
            return 0;

        if (left == right || right - left == 1) {
            if (grid_row[left] < 0)
                return grid_row.length - left;
            else if (grid_row[right] < 0)
                return grid_row.length - right;

            return 0;
        }

        int mid = (right - left) / 2 + left;

        if (grid_row[mid] >= 0)
            return count1DUtil(grid_row,mid+1, right);
        else
            return count1DUtil(grid_row, left, mid);

    }

    public static void testSample() {
        int[][] grid1 = new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int[][] grid2 = new int[][]{{3,2},{1,0}};
        int[][] grid3 = new int[][]{{7,6,6,6,3,3,-2},{-2,-3,-3,-3,-5,-5,-5},{-2,-4,-5,-5,-5,-5,-5},{-3,-5,-5,-5,-5,-5,-5},{-4,-5,-5,-5,-5,-5,-5},
                {-5,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5},{-5,-5,-5,-5,-5,-5,-5}};

        System.out.println("Test grid 1:" + Arrays.deepToString(grid1));
        System.out.println("Result on grid 1: " + countNegatives(grid1));

        System.out.println("Test grid 2:" + Arrays.deepToString(grid2));
        System.out.println("Result on grid 2: " + countNegatives(grid2));

        System.out.println("Test grid 3:" + Arrays.deepToString(grid3));
        System.out.println("Result on grid 3: " + countNegatives(grid3));
    }
}
