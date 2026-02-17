package Kama;

import java.util.*;

public class q94 {
    /*
     * 卡码网 94. 城市间货物运输 I
     * https://kamacoder.com/problempage.php?pid=1152
     */

    private static List<List<int[]>> adjList;

    private static int N;
    private static int M;

    private static int bellmanFord() {
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        List<int[]> fromNodes;
        for (int i=0;i<N-1;++i) {

            for (int j=1;j<=N;++j) {
                fromNodes = adjList.get(j);

                for (int[] path : fromNodes) {
                    if (minDist[path[0]] != Integer.MAX_VALUE && minDist[j] > minDist[path[0]] + path[2]) {
                        minDist[j] = minDist[path[0]] + path[2];
                    }
                }
            }
        }

        return minDist[N];
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        N = myScanner.nextInt();
        M = myScanner.nextInt();

        adjList = new ArrayList<>();

        for (int i=0;i<=N;++i) {
            adjList.add(new ArrayList<>());
        }

        int s,t,v;
        for (int i=0;i<M;++i) {
            s = myScanner.nextInt();
            t = myScanner.nextInt();
            v = myScanner.nextInt();

            adjList.get(t).add(new int[]{s,t,v});
        }

        int res = bellmanFord();

        if (res == Integer.MAX_VALUE)
            System.out.println("unconnected");
        else
            System.out.println(res);

        myScanner.close();
    }
}
