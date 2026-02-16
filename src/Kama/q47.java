package Kama;

import java.util.*;

public class q47 {
    /*
     * 卡码网 47. 参加科学大会
     * https://kamacoder.com/problempage.php?pid=1047
     */

    private static class Edge implements Comparable<Edge> {
        int to;
        int time;

        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.time, other.time);  // Min-Heap based on time
        }
    }

    private static void trivialDijkstra() {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[] minDist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[][] adjMatrix = new int[N + 1][N + 1];

        for (int i = 0; i < M; ++i) {
            adjMatrix[myScanner.nextInt()][myScanner.nextInt()] = myScanner.nextInt();
        }

        // System.out.println(Arrays.deepToString(adjMatrix));

        for (int i = 1; i <= N; ++i)
            minDist[i] = (i == 1) ? 0 : Integer.MAX_VALUE;

        int currDist, curr;
        while (true) {
            currDist = Integer.MAX_VALUE;
            curr = -1;

            for (int i = 1; i <= N; ++i) {
                if (minDist[i] < currDist && !visited[i]) {
                    currDist = minDist[i];
                    curr = i;
                }
            }

            if (curr == -1) break;
            else {
                visited[curr] = true;

                for (int i = 1; i <= N; ++i) {
                    if (adjMatrix[curr][i] != 0) {
                        minDist[i] = Math.min(minDist[i], minDist[curr] + adjMatrix[curr][i]);
                    }
                }
            }

            // System.out.println(Arrays.toString(minDist) + ", total=" + totalDist);
        }

        if (!visited[N]) System.out.println(-1);
        else System.out.println(minDist[N]);

        myScanner.close();
    }

    private static void minHeapDijkstra() {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i=0;i<=N;++i)
            adjList.add(new ArrayList<>());

        for (int i=0;i<M;++i) {
            adjList.get(myScanner.nextInt()).add(new Edge(myScanner.nextInt(), myScanner.nextInt()));
        }

        PriorityQueue<Edge> heap = new PriorityQueue<>();
        heap.add(new Edge(1,0));

        int next;
        boolean[] visited = new boolean[N+1];
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;

        for (int i=1;i<=N;++i) {
            if (heap.isEmpty())
                break;

            next = heap.poll().to;
            // System.out.println("next ->" + next);
            // System.out.println(Arrays.toString(minDist));

            visited[next] = true;

            for (Edge connected : adjList.get(next)) {
                if (minDist[next] + connected.time < minDist[connected.to])
                    minDist[connected.to] = minDist[next] + connected.time;

                if (!visited[connected.to])
                    heap.add(connected);
            }
        }

        if (minDist[N] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minDist[N]);

        myScanner.close();
    }

    public static void main(String[] args) {
        minHeapDijkstra();
    }
}
