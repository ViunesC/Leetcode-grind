package Kama;

import java.util.*;

public class q97 {
    /*
     * 卡码网 97. 小明逛公园
     * https://kamacoder.com/problempage.php?pid=1155
     */

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[][] map = new int[N+1][N+1];

        for (int[] row : map)
            Arrays.fill(row, 10001);

        int u,v,w;
        for (int i=0;i<M;++i) {
            u = myScanner.nextInt();
            v = myScanner.nextInt();
            w = myScanner.nextInt();

            map[u][v] = w;
            map[v][u] = w;
        }

        // Floyd's shortest path algorithm
        // map[i][j] = min(map[i][j], map[i][k] + map[k][j])
        for (int k=1;k<=N;++k) {
            for (int i=1;i<=N;++i) {
                for (int j=1;j<=N;++j) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // print result
        int Q = myScanner.nextInt();

        for (int i=0;i<Q;++i) {
            int result = map[myScanner.nextInt()][myScanner.nextInt()];

            if (result == 10001)
                System.out.println(-1);
            else
                System.out.println(result);
        }

        myScanner.close();
    }
}
