# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution: 
    """
    Leetcode 108: Convert Sorted Array to Binary Search Tree
    """

    def sortedArrayToBST(self, nums: list[int]) -> TreeNode | None:
        if not nums:
            return None
        elif len(nums) == 1:
            return TreeNode(nums[0])

        splt_pt = len(nums) // 2

        root = TreeNode(nums[splt_pt])

        root.left = self.sortedArrayToBST(nums[:splt_pt])
        root.right = self.sortedArrayToBST(nums[splt_pt+1:])

        return root