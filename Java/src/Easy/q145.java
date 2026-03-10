package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 145: Binary Tree Inorder Traversal
 * @author Viunec
 */
public class q145 {
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

//    public static List<Integer> postorderTraversal(TreeNode root) {
//        // Left -> Right -> Root
//        // Method 1 : Using stack
//        if (root == null)
//            return new ArrayList<>();
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        List<Integer> result = new ArrayList<>();
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            result.add(node.val);
//
//            if (node.left != null)
//                stack.push(node.left);
//            if (node.right != null)
//                stack.push(node.right);
//        }
//
//        List<Integer> reversed_result = new ArrayList<>();
//        for (int e : result)
//            reversed_result.add(0,e);
//
//        return reversed_result;
//    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        // Left -> Right -> Root
        // Method 2 : Using recursion
        List<Integer> result = new ArrayList<>();

        result =  traversalUtil(root, result);
        List<Integer> reversed_result = new ArrayList<>();
        for (int e : result)
            reversed_result.add(0,e);

        return reversed_result;
    }

    private static List<Integer> traversalUtil(TreeNode root, List<Integer> result) {
         if (root == null)
             return result;

         result.add(root.val);
         result = traversalUtil(root.right, result);
         result = traversalUtil(root.left, result);

         return result;
    }

    public static void testSample() {
         TreeNode root = new TreeNode(1);
         TreeNode n1 = new TreeNode(2);
         TreeNode n2 = new TreeNode(3);

         n1.left = n2;
         root.right = n1;

         List<Integer> result = postorderTraversal(root);
         for (int e : result)
             System.out.print(e + "\n");
    }
}
