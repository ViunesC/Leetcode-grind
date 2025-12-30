package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 515: Find Largest Value in Each Tree Row
 * @author Viunec
 */
public class q515 {
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

    public static List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
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

            currentLevel.sort(null);
            res.add(currentLevel.get(currentLevel.size() - 1));
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

        System.out.println(largestValues(root));
    }
}
