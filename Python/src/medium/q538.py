from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 538. Convert BST to Greater Tree
    """

    prev_sum:int

    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.prev_sum = 0
        self.traverse(root)

        return root

    def traverse(self, root:Optional[TreeNode]):
        # reverse inorder
        if not root:
            return
        
        self.traverse(root.right)

        curr = root.val
        root.val += self.prev_sum
        self.prev_sum += curr

        self.traverse(root.left)