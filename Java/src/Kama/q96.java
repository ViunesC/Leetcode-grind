package Kama;

import java.util.*;

public class q96 {
    /*
     * 卡码网 96. 城市间货物运输 III
     * https://kamacoder.com/problempage.php?pid=1154
     */

    private static List<List<int[]>> adjList;

    private static int N;

    private static void bellmanFord(int src, int dst, int k) {
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;

        int[] lastMinDist;

        for (int i=0;i<=k;++i) {
            lastMinDist = Arrays.copyOf(minDist, N + 1);

            for (int j=1;j<=N;++j) {

                for (int[] edge : adjList.get(j)) {

                    if (lastMinDist[edge[0]] != Integer.MAX_VALUE && minDist[edge[1]] > lastMinDist[edge[0]] + edge[2]) {
                        minDist[edge[1]] = lastMinDist[edge[0]] + edge[2];
                    }
                }
            }
        }

        if (minDist[dst] == Integer.MAX_VALUE)
            System.out.println("unreachable");
        else
            System.out.println(minDist[dst]);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        N = myScanner.nextInt();
        int M = myScanner.nextInt();

        adjList = new ArrayList<>();

        for (int i=0;i<=N;++i) {
            adjList.add(new ArrayList<>());
        }

        int s;
        for (int i=0;i<M;++i) {
            s = myScanner.nextInt();
            adjList.get(s).add(new int[]{s, myScanner.nextInt(), myScanner.nextInt()});
        }

        int src = myScanner.nextInt();
        int dst = myScanner.nextInt();
        int k = myScanner.nextInt();

        bellmanFord(src, dst, k);

        myScanner.close();
    }
}
