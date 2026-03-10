package Kama;

import java.util.*;

public class q105 {
    private static int bfs(List<List<Integer>> graph, int N) {
        /*
         * 卡码网 105. 有向图的完全联通
         * https://kamacoder.com/problempage.php?pid=1177
         */

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> searched = new HashSet<>();

        queue.push(0);
        searched.add(0);
        int count = 1;

        int next;
        List<Integer> adjNodes;
        while(!queue.isEmpty()) {
            next = queue.removeLast();

            adjNodes = graph.get(next);
            for (int node : adjNodes) {
                if (!searched.contains(node)) {
                    count++;
                    searched.add(node);
                    queue.push(node);
                }
            }
        }

        return (count == N) ? 1 : -1;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int K = myScanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<N;++i) {
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<K;++i) {
            graph.get(myScanner.nextInt()-1).add(myScanner.nextInt()-1);
        }

        System.out.println(bfs(graph, N));
    }
}
