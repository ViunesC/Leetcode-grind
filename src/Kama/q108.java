package Kama;

import java.util.Scanner;

public class q108 {
    /*
     * 卡码网 108. 多余的边
     * https://kamacoder.com/problempage.php?pid=1181
     */

    private static int[] father;

    private static int find(int u) {
        if (father[u] == u) return u;

        return father[u] = find(father[u]);
    }

    private static boolean join(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) return true;

        father[v] = u;
        return false;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();

        father = new int[N+1];

        for (int i=0;i<=N;++i) {
            father[i] = i;
        }

        int x,y;
        for (int i=0;i<N;++i) {
            x = myScanner.nextInt();
            y = myScanner.nextInt();

            if (join(x,y)) {
                System.out.println(x + " " + y);
                return;
            }
        }
    }
}
