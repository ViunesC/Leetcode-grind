package Kama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q98 {
    /*
     * 卡码网 98. 可达路径
     * https://kamacoder.com/problempage.php?pid=1170
     */

    private static List<List<Integer>> adjList;
    private static List<List<Integer>> result;
    private static List<Integer> path;

    public static void dfs(int next, int target) {
        if (next == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        List<Integer> temp = adjList.get(next);

        for (int e : temp) {
            if (path.contains(e))
                continue;

            path.add(e);
            dfs(e, target);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        adjList = new ArrayList<>();
        path = new ArrayList<>();
        result = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            adjList.get(myScanner.nextInt() - 1).add(myScanner.nextInt() - 1);
        }

        path.add(0);
        dfs(0, n - 1);

        if (result.isEmpty())
            System.out.println(-1);

        for (List<Integer> list : result) {
            System.out.print(list.get(0) + 1);
            for (int i = 1; i < list.size(); ++i) {
                System.out.print(" ");
                System.out.print(list.get(i) + 1);
            }
            System.out.print("\n");
        }
    }

}
