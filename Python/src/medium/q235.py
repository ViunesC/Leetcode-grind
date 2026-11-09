# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    """
    Leetcode 235: Lowest Common Ancestor of a Binary Search Tree
    """

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q:
            # if reaching leaf or reached any of the node
            # return root as if p or q is reached first then they do not have root that are more lower
            return root

        if (p.val < root.val and root.val < q.val) or (p.val > root.val and root.val > q.val):
            # if root is 'sandwiched' between p and q, it means that it must be the LCA of both
            return root
        elif p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else:
            return self.lowestCommonAncestor(root.right, p, q)