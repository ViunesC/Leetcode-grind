# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 654: Maximum Binary Tree
    """

    def constructMaximumBinaryTree(self, nums: list[int]) -> TreeNode | None:
        if not nums:
            return None

        max_idx = self.findMax(nums)

        node = TreeNode(nums[max_idx])
        node.left = self.constructMaximumBinaryTree(nums[:max_idx])
        node.right = self.constructMaximumBinaryTree(nums[max_idx+1:])

        return node


    def findMax(self, nums: list[int]) -> int:
        if not nums:
            return -1

        max_v, max_idx = nums[0], 0

        for i,v in enumerate(nums):
            if v > max_v:
                max_v = v
                max_idx = i

        return max_idx