package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class q404 {
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

    public static int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode currNode;
        while(!queue.isEmpty()) {
            currNode = queue.poll();

            if (currNode.left != null) {
                if (currNode.left.left == null && currNode.left.right == null) {
                    res += currNode.left.val;
                }
                queue.add(currNode.left);
            }

            if (currNode.right != null) queue.add(currNode.right);
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

        System.out.println(sumOfLeftLeaves(root));
    }

}
