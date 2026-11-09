# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    """
    Leetcode 236: Lowest Common Ancestor of a Binary Tree
    """
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # post-order traversal to check subtrees before checking parent
        if not root or root == p or root == q: # if root is one of them, return
            return root # cover the case where p/q is parent of q/p

        lft = self.lowestCommonAncestor(root.left, p, q)
        rgt = self.lowestCommonAncestor(root.right, p, q)

        if (lft == p and rgt == q) or (lft == q and rgt == p): # p and q in diff subtrees, root is LCA
            return root
        elif not lft and rgt: # right subtree found p/q/LCA, return
            return rgt
        elif lft and not rgt: # left subtree found p/q/LCA, return
            return lft
        else:
            return lft # return None