package Kama;

import java.util.*;

public class q117 {
    /*
     * 卡码网 117. 软件构建
     * https://kamacoder.com/problempage.php?pid=1191
     */

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        int[] inDegree = new int[N];
        Map<Integer, List<Integer>> deps = new HashMap<>();
        for (int i=0;i<N;++i) {
            deps.put(i, new ArrayList<>());
        }

        int s,t;
        for (int i=0;i<M;++i) {
            s = myScanner.nextInt();
            t = myScanner.nextInt();

            inDegree[t]++;
            deps.get(s).add(t);
        }

        boolean hasDep = true;
        List<Integer> output = new ArrayList<>();
        while (hasDep) {
            hasDep = false;

            for (int i=0;i<N;++i) {
                if (inDegree[i] == 0) {
                    // if the file has 0 indegree (it does not depend on any files)
                    // mark it for installing next
                    // then reduce the indegree of all files that depend on it
                    // finally reduce it's indegree by 1 (so it becomes -1, which means it has been installed)
                    // that will not be searched again
                    hasDep = true;

                    for (int node : deps.get(i)) {
                        inDegree[node]--;
                    }

                    output.add(i);
                    inDegree[i]--;
                }
            }
        }

        if (output.size() != N) {
            System.out.println(-1);
        } else {
            for (int i=0;i<N;++i) {
                if (i != 0)
                    System.out.print(" ");

                System.out.print(output.get(i));
            }

        }

        myScanner.close();
    }
}
