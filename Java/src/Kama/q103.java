package Kama;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class q103 {
    /*
     * 卡码网 103. 高山流水
     * https://kamacoder.com/problempage.php?pid=1175
     */

    // 采用 DFS 进行搜索
    public static void dfs(int[][] heights, int x, int y, boolean[][] visited, int preH) {
        // 遇到边界或者访问过的点，直接返回
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y]) return;
        // 不满足水流入条件的直接返回
        if (heights[x][y] < preH) return;
        // 满足条件，设置为true，表示可以从边界到达此位置
        visited[x][y] = true;

        // 向下一层继续搜索
        dfs(heights, x + 1, y, visited, heights[x][y]);
        dfs(heights, x - 1, y, visited, heights[x][y]);
        dfs(heights, x, y + 1, visited, heights[x][y]);
        dfs(heights, x, y - 1, visited, heights[x][y]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        // 初始化两个二位boolean数组，代表两个边界
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // 从左右边界出发进行DFS
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, i, n - 1, atlantic, Integer.MIN_VALUE);
        }

        // 从上下边界出发进行DFS
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);
            dfs(heights, m - 1, j, atlantic, Integer.MIN_VALUE);
        }

        // 当两个边界二维数组在某个位置都为true时，符合题目要求
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        // 打印结果
        for (List<Integer> list : res) {
            for (int k = 0; k < list.size(); k++) {
                if (k == 0) {
                    System.out.print(list.get(k) + " ");
                } else {
                    System.out.print(list.get(k));
                }
            }
            System.out.println();
        }
    }
}
