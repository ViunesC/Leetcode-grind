package Misc.Graph;

import java.util.*;

public class BFS {
    private Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    public void search(int start) {
        // list all connected nodes starting from start
        Set<Integer> searched = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        System.out.println("Running BFS on graph:");
        stack.push(start);
        searched.add(start);
        System.out.print(start);

        int[] adjacentNodes;
        while (!stack.isEmpty()) {
            adjacentNodes = graph.listAll(stack.pop());

            for (int e : adjacentNodes) {
                if (searched.contains(e))
                    continue;
                System.out.print(",");
                System.out.print(e);

                searched.add(e);
                stack.push(e);
            }
        }
    }
}
