package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 199: Binary Tree Right View Traversal
 * @author Viunec
 */
public class q199 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        int count;
        List<Integer> currentLevel = new ArrayList<>();;
        TreeNode currentNode;

        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();

            for (int i=0;i<count;i++) {
                currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            res.add(currentLevel.get(currentLevel.size() - 1));
            currentLevel.clear();
        }

        return res;
    }

    public static void testSample() {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);

        n1.right = n3;
        n2.right = n4;
        root.left = n1;
        root.right = n2;

        System.out.println(rightSideView(root));
    }
}
