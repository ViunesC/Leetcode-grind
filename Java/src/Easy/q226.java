package Easy;

/**
 * Leetcode 226: Invert Binary Tree
 */
public class q226 {
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        // swap left and right children of every node

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);

        return root;
    }

    public static void testSample() {
        System.out.println("Not implemented.");
    }

}
