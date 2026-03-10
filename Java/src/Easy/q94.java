package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 94: Binary Tree Inorder Traversal
 * @author Viunec
 */
public class q94 {
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

    public static List<Integer> inorderTraversal(TreeNode root) {
        // Left -> Root -> Right
        // Method 1 : Using stack
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        List<Integer> result = new ArrayList<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }

        return result;
    }

//    public static List<Integer> inorderTraversal(TreeNode root) {
//        // Left -> Root -> Right
//        // Method 2 : Using recursion
//        List<Integer> result = new ArrayList<>();
//
//        return traversalUtil(root, result);
//    }

    private static List<Integer> traversalUtil(TreeNode root, List<Integer> result) {
         if (root == null)
             return result;

         result = traversalUtil(root.left, result);
         result.add(root.val);
         result = traversalUtil(root.right, result);

         return result;
    }

    public static void testSample() {
         TreeNode root = new TreeNode(1);
         TreeNode n1 = new TreeNode(2);
         TreeNode n2 = new TreeNode(3);

         n1.left = n2;
         root.right = n1;

         List<Integer> result = inorderTraversal(root);
         for (int e : result)
             System.out.print(e + "\n");
    }
}
