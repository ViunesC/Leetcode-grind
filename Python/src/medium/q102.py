from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 102: Binary Tree Level Order Traversal
    """

    def levelOrder(self, root: TreeNode | None) -> list[list[int]]:
        if not root:
            return []

        q:deque[TreeNode] = deque([root])
        result = []

        current_level = []
        while q:
            for _ in range(len(q)):
                curr = q.popleft()

                if not curr:
                    continue

                current_level.append(curr.val)
                q.append(curr.left)
                q.append(curr.right)

            if current_level:
                result.append(current_level.copy())
                current_level.clear()

        return result