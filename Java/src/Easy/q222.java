package Easy;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 222: Count Complete Binary Tree Nodes
 * @author Viunec
 */
public class q222 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int res = 0;

        TreeNode currNode;
        int levelLength;
        queue.add(root);

        while (!queue.isEmpty()) {
            levelLength = queue.size();

            for (int i = 0; i < levelLength; i++) {
                currNode = queue.poll();
                res++;

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }

        return res;
    }

    public static void testSample() {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        n2.left = n3;
        n2.right = n4;
        root.left = n1;
        root.right = n2;

        System.out.println(countNodes(root));
    }
}
