package Kama;

import java.util.*;

public class q95 {
    /*
     * 卡码网 95. 城市间货物运输 II
     * https://kamacoder.com/problempage.php?pid=1153
     */

    private static List<List<int[]>> adjList;
    private static int N;

    private static String bellmanFord() {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] inQueue = new boolean[N+1];
        int[] count = new int[N+1];
        int[] minDist = new int[N+1];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;
        queue.push(1);
        inQueue[1] = true;
        count[1]++;

        List<int[]> next;
        int r;
        while(!queue.isEmpty()) {
            r = queue.removeLast();
            inQueue[r] = false;
            next = adjList.get(r);

            for (int[] path : next) {
                if (minDist[path[1]] > minDist[path[0]] + path[2]) {
                    minDist[path[1]] = minDist[path[0]] + path[2];

                    if (!inQueue[path[1]]) {
                        queue.push(path[1]);
                        inQueue[path[1]] = true;
                        count[path[1]]++;
                    }

                    if (count[path[1]] == N)
                        return "circle";
                }
            }
        }

        if (minDist[N] == Integer.MAX_VALUE)
            return "unconnected";
        else
            return Integer.toString(minDist[N]);
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        N = myScanner.nextInt();
        int M = myScanner.nextInt();
        adjList = new ArrayList<>();

        for (int i=0;i<=N;++i)
            adjList.add(new ArrayList<>());

        int s,t,v;
        for (int i=0;i<M;++i) {
            s = myScanner.nextInt();
            t = myScanner.nextInt();
            v = myScanner.nextInt();

            adjList.get(s).add(new int[]{s,t,v});
        }

        System.out.println(bellmanFord());

        myScanner.close();
    }
}
