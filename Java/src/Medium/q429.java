package Medium;

import java.util.*;

/**
 * Leetcode 429: N-ary Tree Level Order Traversal
 * @author Viunec
 */
public class q429 {
    private static class Node {
      int val;
      List<Node> children;
      Node() {}
      Node(int _val) { val = _val; }
      Node(int _val, List<Node> _children) {
          val = _val;
          children = _children;
      }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();

        int count;
        List<Integer> currentLevel;
        Node currentNode;

        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();

            currentLevel = new ArrayList<>();
            for (int i=0;i<count;i++) {
                currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                queue.addAll(currentNode.children);
            }

            res.add(currentLevel);
        }

        return res;
    }

    public static void testSample() {
        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        root.children = new ArrayList<>(Arrays.asList(n1,n2,n3));
        n1.children = new ArrayList<>(Arrays.asList(n4,n5));
        n2.children = new ArrayList<>();
        n3.children = new ArrayList<>();
        n4.children = new ArrayList<>();
        n5.children = new ArrayList<>();

        System.out.println(levelOrder(root));
    }
}
