# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 101: Symmetric Tree
    """

    def isSymmetric(self, root: TreeNode | None) -> bool:
        if not root:
            return True

        return self.checkSubTrees(root.left, root.right)
        

    def checkSubTrees(self, left: TreeNode | None, right: TreeNode | None) -> bool:

        if not left and not right:
            return True
        elif (left and not right) or (not left and right) or left.val != right.val:
            return False

        return self.checkSubTrees(left.left, right.right) and self.checkSubTrees(left.right, right.left)