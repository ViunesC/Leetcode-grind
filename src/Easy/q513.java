package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class q513 {
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

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode currNode;
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (currNode.right != null) queue.add(currNode.right);
            if (currNode.left != null) queue.add(currNode.left);

            if (queue.isEmpty()) return currNode.val;
        }

        return -1;
    }

    public static void testSample() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);

        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);

        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);

        n6.left = n7;
        n4.left = n6;
        n2.left = n4;
        n2.right = n5;

        n1.left = n3;

        root.left = n1;
        root.right = n2;
        /*
         * Sample tree:
         *           1
         *         /  \
         *        2    3
         *       /    / \
         *      4    5   6
         *          /
         *         7
         *        /
         *       8
         */

        System.out.println(findBottomLeftValue(root));
    }
}
