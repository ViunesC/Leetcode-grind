# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 257: Binary Tree Paths
    """

    path: list[str] # currently exploring
    result: list[list[str]] # result set


    def binaryTreePaths(self, root: TreeNode | None) -> list[str]:
        self.path = []
        self.result = []

        self.backTrack(root)

        flattened = []
        for p in self.result:
            flattened.append("->".join(p))

        return flattened


    def backTrack(self, root: TreeNode):
        self.path.append(str(root.val))
        if not root.left and not root.right:
            # record
            self.result.append(self.path.copy())
        else:
            if root.left:
                self.backTrack(root.left)
            if root.right:
                self.backTrack(root.right)

        # backtrack (erase)
        self.path.pop()
