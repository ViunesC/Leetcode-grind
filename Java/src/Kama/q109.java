package Kama;

import java.util.Scanner;

public class q109 {
    /*
     * 卡码网 109. 多余的边II
     * https://kamacoder.com/problempage.php?pid=1182
     */

    private static int[] father;
    private static int[][] edges;
    private static int N;

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


    private static boolean isTreeAfterRemoval(int toBeRemoved) {
        father = new int[N+1];

        for (int i=0;i<=N;++i)
            father[i] = i;

        for (int i=0;i<N;++i) {
            if (i == toBeRemoved) continue;

            if (join(edges[i][0], edges[i][1]))
                return false;
        }

        return true;
    }

    private static void removeCycle() {
        father = new int[N+1];

        for (int i=0;i<=N;++i)
            father[i] = i;

        for (int i=0;i<N;++i) {
            if (join(edges[i][0], edges[i][1])) {
                System.out.println(edges[i][0] + " " + edges[i][1]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        N = myScanner.nextInt();
        edges = new int[N][2];
        int[] inDegree = new int[N + 1];

        int t;
        for (int i=0;i<N;++i) {
            edges[i][0] = myScanner.nextInt();
            t = myScanner.nextInt();

            edges[i][1] = t;
            inDegree[t]++;
        }


        for (int i=edges.length-1;i>=0;--i) {
            // check in-degree of each dest. node
            // from bottom to top, iterate all edges

            if (inDegree[edges[i][1]] > 1) {
                // if in-degree > 1, we need to remove one or more edges
                // since we only allow in degree of a node in a directed acyclic tree to be 0 (root) or 1
                if (isTreeAfterRemoval(i)) {
                    // if remove the node makes graph a tree, we accept it as our final answer
                    System.out.println(edges[i][0] + " " + edges[i][1]);
                    return;
                }
            }
        }

        // if removing all edges does not make a tree
        // the graph will definitely contain a directed cycle
        // we need to remove an edge to remove cycle
        // same as we did in 108. 多余的边
        removeCycle();
    }
}
