package Medium;

public class q63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int r=0;r<grid.length;++r) {
            for (int c=0;c<grid[0].length;++c) {
                if (obstacleGrid[r][c] == 1) {
                    grid[r][c] = 0;
                    continue;
                }

                if (r==0 && c==0)
                    grid[r][c] = 1;
                else if (r==0)
                    grid[r][c] = grid[r][c-1];
                else if (c==0)
                    grid[r][c] = grid[r-1][c];
                else
                    grid[r][c] = grid[r-1][c] + grid[r][c-1];
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

    public static void testSample() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0,0},{0,1,0},{0,0,0}}));
    }
}
