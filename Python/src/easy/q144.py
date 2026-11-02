# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 144: Binary Tree Preorder Traversal
    """

    printed: list[int]

    def preorderTraversal(self, root: TreeNode | None) -> list[int]:
        self.printed = []
        self.traverse(root)

        return self.printed

    def traverse(self, root: TreeNode | None):
        # preorder: mid -> left -> right
        if not root:
            return

        self.printed.append(root.val)
        self.traverse(root.left)
        self.traverse(root.right)