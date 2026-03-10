package Easy;

public class q110 {
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

    public static boolean isBalanced(TreeNode root) {
        return subtreeHeight(root) != -1;
    }

    private static int subtreeHeight(TreeNode root) {
        // compare the height of two subtrees
        // if their difference > 1 they are not balanced
        // or if one or both of them are -1, they are already identified
        // as not balanced.

        if (root == null) return 0;

        int leftHeight = subtreeHeight(root.left);
        int rightHeight = subtreeHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        else return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void testSample() {
        System.out.println("Not implemented.");
    }
}
