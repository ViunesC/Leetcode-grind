package Kama;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class q100 {
    /*
     * 卡码网 100. 最大岛屿的面积
     * https://kamacoder.com/problempage.php?pid=1172
     */

    private static int[][] nav = {{-1,0},{0,-1},{1,0},{0,1}};

    public static int bfs(int[][] map, int x, int y, boolean[][] searched) {
        Deque<int[]> queue = new ArrayDeque<>();

        searched[x][y] = true;
        int[] next = {x, y};
        int r,c, count = 1;

        queue.push(next);
        while (!queue.isEmpty()) {
            next = queue.removeLast();

            for (int i=0;i<4;++i) {
                r = next[0] + nav[i][0];
                c = next[1] + nav[i][1];

                if (r < 0 || r >= map.length || c < 0 || c >= map[0].length)
                    continue;

                if (map[r][c] == 1 && !searched[r][c]) {
                    // System.out.println("Yikes");
                    count++;
                    searched[r][c] = true;
                    queue.push(new int[]{r,c});
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N][M];
        boolean[][] searched = new boolean[N][M];

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                map[i][j] = myScanner.nextInt();
            }
        }

        int maxArea = 0;

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                if (map[i][j] == 1 && !searched[i][j]) {
                    maxArea = Math.max(maxArea, bfs(map, i, j, searched));
                }
            }
        }

        System.out.println(maxArea);
    }
}
