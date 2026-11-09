# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 701: Insert into a Binary Search Tree
    """

    def insertIntoBST(self, root: TreeNode | None, val: int) -> TreeNode | None:
        if not root:
            root = TreeNode(val)
            return root

        curr = root
        while True:
            if curr.val > val:
                if curr.left:
                    curr = curr.left
                else:
                    curr.left = TreeNode(val)
                    break
            elif curr.val < val:
                if curr.right:
                    curr = curr.right
                else:
                    curr.right = TreeNode(val)
                    break

        return root