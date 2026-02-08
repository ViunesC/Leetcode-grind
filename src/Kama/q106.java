package Kama;

import java.util.Scanner;

public class q106 {
    /*
     * 卡码网 106. 海岸线计算
     * https://kamacoder.com/problempage.php?pid=1178
     */

    private static int[][] nav = {{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N][M];
        boolean[][] checked = new boolean[N][M];

        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {
                map[i][j] = myScanner.nextInt();
            }
        }

        int r, c, dm=0;
        for (int i=0;i<N;++i) {
            for (int j=0;j<M;++j) {

                if (map[i][j] == 1) {
                    for (int k=0;k<4;++k) {
                        r = i + nav[k][0];
                        c = j + nav[k][1];

                        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) {
                            dm++;
                            continue;
                        }

                        if (map[r][c] == 0)
                            dm++;
                    }
                }
            }
        }

        System.out.println(dm);
    }
}
