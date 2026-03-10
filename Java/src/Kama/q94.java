package Kama;

import java.util.*;

public class q94 {
    /*
     * 卡码网 94. 城市间货物运输 I
     * https://kamacoder.com/problempage.php?pid=1152
     */

    private static List<List<int[]>> adjList;

    private static int N;

    private static int bellmanFord() {
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        List<int[]> toNodes;
        int next;
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] isQueued = new boolean[N+1];

        queue.push(1);
        isQueued[1] = true;

        while(!queue.isEmpty()) {
            next = queue.removeLast();
            toNodes = adjList.get(next);
            isQueued[next] = false;

            for (int[] path : toNodes) {
                if (minDist[path[1]] > minDist[path[0]] + path[2]) {
                    minDist[path[1]] = minDist[path[0]] + path[2];

                    if (!isQueued[path[1]]) {
                        queue.push(path[1]);
                        isQueued[path[1]] = true;
                    }
                }
            }
        }

        return minDist[N];
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        N = myScanner.nextInt();
        int M = myScanner.nextInt();

        adjList = new ArrayList<>();

        for (int i=0;i<=N;++i) {
            adjList.add(new ArrayList<>());
        }

        int s,t,v;
        for (int i=0;i<M;++i) {
            s = myScanner.nextInt();
            t = myScanner.nextInt();
            v = myScanner.nextInt();

            adjList.get(s).add(new int[]{s,t,v});
        }

        int res = bellmanFord();

        if (res == Integer.MAX_VALUE)
            System.out.println("unconnected");
        else
            System.out.println(res);

        myScanner.close();
    }
}
