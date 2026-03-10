package Easy;

import java.util.ArrayList;
import java.util.List;

public class q257 {
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

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        pathfindingUtil(root, new ArrayList<>(), res);
        return res;
    }

    private static void pathfindingUtil(TreeNode root, List<Integer> path, List<String> result) {
        path.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i=0;i<path.size()-1;++i) {
                builder.append(path.get(i));
                builder.append("->");
            }
            builder.append(path.get(path.size()-1));
            result.add(builder.toString());
            return;
        }

        if (root.left != null) {
            pathfindingUtil(root.left, path, result);
            path.remove(path.size()-1);
        }

        if (root.right != null) {
            pathfindingUtil(root.right, path, result);
            path.remove(path.size()-1);
        }
    }

}
