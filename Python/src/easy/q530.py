from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 530: Minimum Absolute Difference in BST
    """

    in_order_list: list[int]

    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        self.in_order_list = []
        min_diff = 10**5

        self.traverse(root)

        for i in range(len(self.in_order_list)):
            if i > 0:
                min_diff = min(min_diff, abs(self.in_order_list[i] - self.in_order_list[i-1]))

        return min_diff


    def traverse(self, root: Optional[TreeNode]):
        if not root:
            return

        self.traverse(root.left)
        self.in_order_list.append(root.val)
        self.traverse(root.right)