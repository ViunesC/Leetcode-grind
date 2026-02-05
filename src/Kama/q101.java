package Kama;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class q101 {
    /*
     * 卡码网 101. 孤岛的总面积
     * https://kamacoder.com/problempage.php?pid=1171
     */

    private static int[][] nav = {{0,-1}, {-1,0}, {0,1}, {1,0}};

    private static int bfs(int[][] map, int x, int y, boolean[][] searched) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.push(new int[]{x,y});
        searched[x][y] = true;

        int r,c, count = 1;
        int[] next;
        boolean isDiscarded = false;
        while (!queue.isEmpty()) {
            next = queue.removeLast();

            for (int i=0;i<4;++i) {
                r = next[0] + nav[i][0];
                c = next[1] + nav[i][1];

                if (r < 0 || r > map.length-1 || c < 0 || c > map[0].length-1) {
                    isDiscarded = true;
                    continue;
                } else if (map[r][c] == 1 && (r == 0 || r == map.length-1 || c == 0 || c == map[0].length-1)) {
                    isDiscarded = true;
                }

                if (map[r][c] == 1 && !searched[r][c]) {
                    searched[r][c] = true;
                    queue.push(new int[]{r,c});
                    count++;
                }
            }
        }

        if (isDiscarded)
            return 0;
        else
            return count;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N][M];
        boolean[][] searched = new boolean[N][M];
        int result = 0;

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                map[i][j] = myScanner.nextInt();
            }
        }

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                if (map[i][j] == 1 && !searched[i][j]) {
                    // System.out.println("i:" + i +" j:" + j);
                    result += bfs(map, i, j, searched);
                }
            }
        }

        System.out.println(result);
    }

}
