# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 98: Validate Binary Search Tree
    """

    path: list[int]

    def isValidBST(self, root: TreeNode | None) -> bool:
        self.path = []
        self.traverse(root)

        for i,v in enumerate(self.path):
            if i > 0 and v <= self.path[i-1]: # if the tree is BST, in-order traversal should print a monotonic increasing array
                return False # if not it's not a BST

        return True


    def traverse(self, root: TreeNode | None):
        # inorder traversal
        if not root:
            return

        self.traverse(root.left)
        self.path.append(root.val)
        self.traverse(root.right)