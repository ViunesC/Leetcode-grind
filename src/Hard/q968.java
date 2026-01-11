package Hard;

public class q968 {
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

    public static int minCameraCover(TreeNode root) {
        int[] result = new int[]{0};
        if (traversal(root, result) == 0) {
            result[0]++;
        }

        return result[0];
    }

    private static int traversal(TreeNode curr, int[] result) {
        if (curr == null)
            // if current node is empty node (node after leaf node),
            // return it's covered (so that leaf nodes are not covered initially)
            return 2;

        // post order traversal
        // left -> right -> root
        // search leaf node first
        int left = traversal(curr.left, result);
        int right = traversal(curr.right, result);

        // state control:
        // 0 - not covered
        // 1 - have camera installed
        // 2 - covered

        if (left == 2 && right == 2)
            // if both children are covered, then the current node isn't covered
            return 0;
        else if (left == 0 || right == 0) {
            // if at least one child isn't covered, we need to install on its parent node (which is current node)
            result[0]++;
            return 1;
        } else {
            // if both child are covered, and at least one of them have camera installed, then parent node is covered
            return 2;
        }
    }

    public static void testSample() {

    }
}
