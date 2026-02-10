package Kama;

import java.util.Scanner;

public class q107 {
    /*
     * 卡码网 107. 寻找存在的路径
     * https://kamacoder.com/problempage.php?pid=1179
     */

    private static int[] father;

    private static int find(int u) {
        if (father[u] == u) return u;

        return find(father[u]);
    }

    private static void join(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) return;

        father[v] = u;
    }

    private static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);

        return u == v;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        father = new int[N+1];

        for (int i=0;i<=N;++i) {
            father[i] = i;
        }

        for (int i=0;i<M;++i) {
            join(myScanner.nextInt(), myScanner.nextInt());
        }

        int u = myScanner.nextInt();
        int v = myScanner.nextInt();

        if (isSame(u,v))
            System.out.println(1);
        else
            System.out.println(0);
    }
}
