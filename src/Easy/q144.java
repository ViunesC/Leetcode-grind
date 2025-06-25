package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 144: Binary Tree Postorder Traversal
 * @author Viunec
 */
public class q144 {
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

//    public static List<Integer> preorderTraversal(TreeNode root) {
//        // Root -> Left -> Right
//        // Method 1 : Using stack
//        if (root == null)
//            return new ArrayList<>();
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        TreeNode current;
//        List<Integer> result = new ArrayList<>();
//        while (!stack.isEmpty()) {
//            current = stack.pop();
//            result.add(current.val);
//
//            if (current.right != null)
//                stack.push(current.right);
//
//            if (current.left != null)
//                stack.push(current.left);
//        }
//
//        return result;
//    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        // Root -> Left -> Right
        // Method 2 : Using recursion
        List<Integer> result = new ArrayList<>();

        return traversalUtil(root, result);
    }

    private static List<Integer> traversalUtil(TreeNode root, List<Integer> result) {
         if (root == null)
             return result;

         result.add(root.val);

         result = traversalUtil(root.left, result);
         result = traversalUtil(root.right, result);

         return result;
    }

    public static void testSample() {
         TreeNode root = new TreeNode(1);
         TreeNode n1 = new TreeNode(2);
         TreeNode n2 = new TreeNode(3);

         n1.right = n2;
         root.left = n1;

         List<Integer> result = preorderTraversal(root);
         for (int e : result)
             System.out.print(e + "\n");
    }
}
