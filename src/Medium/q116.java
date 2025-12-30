package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Leetcode 116: Populating Next Right Pointers in Each Node
 * @author Viunec
 */
public class q116 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);
        int currLevelLength;
        Node currNode;
        while(!queue.isEmpty()) {
            currLevelLength = queue.size();
            for (int i=0;i<currLevelLength;i++) {
                currNode = queue.poll();

                if (i<currLevelLength-1)
                    currNode.next = queue.peek();
                else
                    currNode.next = null;

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }

        return root;
    }

    private static void printNodeUtil(Node root) {
        System.out.println("Node's <next> hierarchy: ");

        Node p;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            p = queue.poll();

            if (p.left != null) queue.add(p.left);
            if (p.right != null) queue.add(p.right);

            if (p.next != null)
                System.out.println(p.val + "->" + p.next.val);
            else
                System.out.println(p.val + "->" + "null");
        }

        System.out.println("Binary tree structure:");

        queue.add(root);
        int currLevelLength;

        while (!queue.isEmpty()) {
            currLevelLength = queue.size();

            for (int i=0;i<currLevelLength;i++) {
                p = queue.poll();
                System.out.print(p.val);

                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);

                if (i < currLevelLength - 1)
                    System.out.print("-");
            }
            System.out.println();
        }

    }

    public static void testSample() {
        Node root = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);

        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        root.left = n1;
        root.right = n2;


        printNodeUtil(connect(root));
    }

}
