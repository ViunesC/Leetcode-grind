package Kama;
import java.util.Scanner;

public class q99 {
    /*
     * 卡码网 99. 计数孤岛
     * https://kamacoder.com/problempage.php?pid=1171
     */

    private static int[][] nav = {{0,-1},{-1,0},{0,1},{1,0}};

    private static void dfs(int[][] map, int x, int y, boolean[][] discovered) {
        int r,c;
        for (int i=0;i<4;++i) {
            r = x + nav[i][0];
            c = y + nav[i][1];

            if (r < 0 || r >= map.length || c < 0 || c >= map.length)
                continue;

            if (map[r][c] == 1 && !discovered[r][c]) {
                discovered[r][c] = true;

                dfs(map, r, c, discovered);
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N][M];
        boolean[][] discovered = new boolean[N][M];

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                map[i][j] = myScanner.nextInt();
            }
        }

        int result = 0;
        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                if (map[i][j] == 1 && !discovered[i][j]) {
                    result++;
                    discovered[i][j] = true;
                    dfs(map, i, j, discovered);
                }
            }
        }

        System.out.println(result);
    }
}
