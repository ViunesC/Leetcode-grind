package Misc.Graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private Graph graph;
    private List<List<Integer>> result;
    private List<Integer> path;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public void search(int start, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        path.add(start);
        searchUtil(start, target);

        System.out.println("Valid path(dfs):");

        for (List<Integer> list : result) {
            System.out.print(list.get(0));
            for (int i=1;i<list.size();++i) {
                System.out.print("->");
                System.out.print(list.get(i));
            }
            System.out.print(";\n");
        }
    }

    private void searchUtil(int next, int target) {
        if (next == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        int[] adjacentNodes = graph.listAll(next);

        for (int node : adjacentNodes) {
            if (path.contains(node))
                continue;

            // System.out.println("Search " + node);
            path.add(node);
            searchUtil(node, target);
            path.remove(path.size()-1);
        }
    }
}
