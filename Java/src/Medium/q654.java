package Medium;

public class q654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructUtil(nums, 0, nums.length - 1);
    }

    private TreeNode constructUtil(int[] nums, int start, int end) {
        if (start > end) return null;

        int pos = start;
        for (int i=start;i<=end;i++) {
            if (nums[i] > nums[pos]) {
                pos = i;
            }
        }

        TreeNode root = new TreeNode(nums[pos]);
        root.left = constructUtil(nums, start, pos - 1);
        root.right = constructUtil(nums, pos + 1, end);

        return root;
    }
}
