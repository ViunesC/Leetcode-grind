package Easy;


/**
 * Leetcode 101: Symmetric Tree
 * @author Viunec
 */
public class q101 {
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

    public static boolean isSymmetric(TreeNode root) {
        // to check if the tree is symmetric
        // we shall compare left and right subtree of every node
        return compareTwoNodes(root.left, root.right);
    }

    private static boolean compareTwoNodes(TreeNode left, TreeNode right) {
        // check cases containing empty node
        if (left == null && right == null) {
            return true;
        } else if ((left != null && right == null)
                || (left == null && right != null)) {
            return false;
        }

        if (left.val != right.val) return false;

        // cases where both left & right are not empty
        return compareTwoNodes(left.left, right.right) && compareTwoNodes(left.right, right.left);
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

        System.out.println(isSymmetric(root));
    }
}
