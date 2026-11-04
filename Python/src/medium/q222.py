from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 222: Count Complete Tree Nodes
    """

    def countNodes(self, root: TreeNode | None) -> int:
        if not root:
            return 0

        left_height, right_height = 0, 0
        left,right = root.left, root.right

        while left:
            left = left.left
            left_height += 1

        while right:
            right = right.right
            right_height += 1

        if left_height == right_height: # full-complete binary tree
            return 2 * (2**left_height) - 1 # fixed formula to get # of nodes in fcb

        return self.countNodes(root.left) + self.countNodes(root.right) + 1 # not fcb, keep iterating left and right subtree