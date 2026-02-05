package Kama;

import java.util.Scanner;

public class q102 {
    /*
     * 卡码网 102. 沉没孤岛
     * https://kamacoder.com/problempage.php?pid=1174
     */

    private static int[][] nav = {{0,-1},{-1,0},{0,1},{1,0}};

    private static void dfs(int[][] map, int x, int y, boolean[][] notIsolated) {
        int r,c;

        for (int i=0;i<4;++i) {
            r = x + nav[i][0];
            c = y + nav[i][1];

            if (r < 0 || r >= map.length || c < 0 || c >= map[0].length)
                continue;

            if (map[r][c] == 1 && !notIsolated[r][c]) {
                notIsolated[r][c] = true;
                dfs(map, r, c, notIsolated);
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N][M];
        boolean[][] notIsolated = new boolean[N][M];

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                map[i][j] = myScanner.nextInt();
            }
        }

        // North boundary
        for (int k=0;k<M;++k) {
            if (map[0][k] == 1 && !notIsolated[0][k]) {
                notIsolated[0][k] = true;
                dfs(map, 0, k, notIsolated);
            }
        }

        // South boundary
        for (int k=0;k<M;++k) {
            if (map[N-1][k] == 1 && !notIsolated[N-1][k]) {
                notIsolated[N-1][k] = true;
                dfs(map, N-1, k, notIsolated);
            }
        }

        // East boundary
        for (int k=0;k<N;++k) {
            if (map[k][M-1] == 1 && !notIsolated[k][M-1]) {
                notIsolated[k][M-1] = true;
                dfs(map, k, M-1, notIsolated);
            }
        }

        // West boundary
        for (int k=0;k<N;++k) {
            if (map[k][0] == 1 && !notIsolated[k][0]) {
                notIsolated[k][0] = true;
                dfs(map, k, 0, notIsolated);
            }
        }

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                if (map[i][j] == 1 && !notIsolated[i][j])
                    System.out.print(0);
                else
                    System.out.print(map[i][j]);
                if (j != M-1)
                    System.out.print(" ");
            }

            if (i != N-1)
                System.out.print("\n");
        }
    }
}
