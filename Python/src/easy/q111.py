# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 111: Minimum Depth of Binary Tree
    """

    def minDepth(self, root: TreeNode | None) -> int:
        if not root:
            return 0

        return self.get_min(root)

    def get_min(self, root: TreeNode | None) -> int:
        if not root.left and not root.right:
            # is leaf
            return 1

        lft_min = self.get_min(root.left) if root.left else 10**5+1
        rgt_min = self.get_min(root.right) if root.right else 10**5+1

        return min(lft_min, rgt_min) + 1
        