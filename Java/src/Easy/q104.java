package Easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Leetcode 104: Maximum Depth of Binary Tree
 *
 * @author Viunec
 */
public class q104 {
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

    public static int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int currLevelLength;
        TreeNode currNode;
        while (!queue.isEmpty()) {
            currLevelLength = queue.size();
            result++;

            for (int i = 0; i < currLevelLength; i++) {
                currNode = queue.poll();

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }

        return result;
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

        System.out.println(maxDepth(root));
    }
}
