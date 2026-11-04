# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 110: Balanced Binary Tree
    """

    balanced: bool

    def isBalanced(self, root: TreeNode | None) -> bool:
        self.balanced = True
        self.check(root)

        return self.balanced

    def check(self, root: TreeNode | None) -> int:
        if not root:
            return 0

        l_h = self.check(root.left)
        r_h = self.check(root.right)

        if not self.balanced:
            return -1

        if abs(l_h - r_h) > 1:
            self.balanced = False

        return max(l_h, r_h) + 1
        