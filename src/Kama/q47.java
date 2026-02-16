package Kama;

import java.util.*;

public class q47 {
    /*
     * 卡码网 47. 参加科学大会
     * https://kamacoder.com/problempage.php?pid=1047
     */

    private static int[][] adjMatrix;

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int N = myScanner.nextInt();
        int M = myScanner.nextInt();

        adjMatrix = new int[N + 1][N + 1];

        for (int i = 0; i < M; ++i) {
            adjMatrix[myScanner.nextInt()][myScanner.nextInt()] = myScanner.nextInt();
        }

        // System.out.println(Arrays.deepToString(adjMatrix));

        int[] minDist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

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
    }
}
