package Medium;

public class q337 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int rob(TreeNode root) {
        int[] results = robUtil(root);

        return Math.max(results[0], results[1]);
    }

    private static int[] robUtil(TreeNode node) {
        if (node == null)
            return new int[]{0,0};

        int[] lefts = robUtil(node.left);
        int[] rights = robUtil(node.right);

        return new int[]{Math.max(lefts[0], lefts[1]) + Math.max(rights[0], rights[1]), node.val + lefts[0] + rights[0]};
    }

    public static void testSample() {

    }
}
