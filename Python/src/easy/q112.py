# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 112: Path Sum
    """

    has_sum: bool
    curr_sum: int

    def hasPathSum(self, root: TreeNode | None, targetSum: int) -> bool:
        self.has_sum = False
        self.curr_sum = 0

        self.backTrack(root, targetSum)

        return self.has_sum


    def backTrack(self, root: TreeNode | None, targetSum: int):
        if self.has_sum or not root:
            return

        if not root.left and not root.right and root.val + self.curr_sum == targetSum: # if root is leaf node and sum = target sum
            self.has_sum = True
            return

        self.curr_sum += root.val

        self.backTrack(root.left, targetSum)
        self.backTrack(root.right, targetSum)

        # backtrack
        self.curr_sum -= root.val