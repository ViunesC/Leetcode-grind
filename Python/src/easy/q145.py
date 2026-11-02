# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 145: Binary Tree Postorder Traversal
    """

    printed: list[int]

    def postorderTraversal(self, root: TreeNode | None) -> list[int]:
        self.printed = []
        self.traverse(root)

        return self.printed

    def traverse(self, root: TreeNode | None):
        # postorder: left -> right -> mid
        if not root:
            return

        self.traverse(root.left)
        self.traverse(root.right)
        self.printed.append(root.val)