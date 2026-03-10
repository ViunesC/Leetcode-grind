package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 144: Binary Tree Level Order Traversal II
 * @author Viunec
 */
public class q107 {
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

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        int count;
        List<Integer> currentLevel;
        TreeNode currentNode;

        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();

            currentLevel = new ArrayList<>();
            for (int i=0;i<count;i++) {
                currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

            res.add(currentLevel);
        }

        List<List<Integer>> res_reversed = new ArrayList<>();
        for (List<Integer> list : res) {
            res_reversed.add(0, list);
        }

        return res_reversed;
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

        System.out.println(levelOrderBottom(root));
    }
}
