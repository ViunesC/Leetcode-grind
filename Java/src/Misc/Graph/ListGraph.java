package Misc.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListGraph implements Graph {
    class Node {
        int val;

        Node(int val) {
           this.val = val;
        }

        Node() {
            this.val = -1;
        }
    }

    private List<LinkedList<Node>> adjList;

    private int numNodes;

    public ListGraph(int n) {
        this.adjList = new ArrayList<>();

        this.numNodes = n;
    }

    public ListGraph(int[][] list) {
        this.adjList = new ArrayList<>();

        this.numNodes = list.length;

        LinkedList<Node> temp;
        for (int[] arr : list) {
            temp = new LinkedList<>();

            for (int e : arr) {
                temp.add(new Node(e));
            }

            this.adjList.add(temp);
        }
    }

    public int[] listAll(int val) {
        if (val < 0 || val >= this.numNodes)
            return new int[0];

        LinkedList<Node> list = this.adjList.get(val);
        int[] result = new int[list.size()];

        for (int i=0;i<result.length;++i) {
            result[i] = list.get(i).val;
        }

        return result;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("[\n");

        for (int i=0;i<adjList.size();++i) {
            output.append(i).append("=>");

            for (Node n : adjList.get(i)) {
                output.append(n.val).append(",");
            }

            output.deleteCharAt(output.length()-1);
            output.append("\n");
        }

        output.append("]");

        return output.toString();
    }
}
