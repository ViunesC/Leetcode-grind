# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Leetcode 226: Invert Binary Tree
    """

    def invertTree(self, root: TreeNode | None) -> TreeNode | None:
        # recursive method
        if not root:
            return

        tmp = root.right
        root.right = self.invertTree(root.left)
        root.left = self.invertTree(tmp)

        return root