# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 404: Sum of Left Leaves
    """

    def sumOfLeftLeaves(self, root: TreeNode | None) -> int:
        s = 0
        if root.left:
            if not root.left.left and not root.left.right:
                # find a left leaf
                s += root.left.val
            else:
                # keep searching
                s += self.sumOfLeftLeaves(root.left)

        if root.right:
            # keep searching
            s += self.sumOfLeftLeaves(root.right)

        return s