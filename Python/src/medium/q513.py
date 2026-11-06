from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 513. Find Bottom Left Tree Value
    """

    def findBottomLeftValue(self, root: TreeNode | None) -> int:
        q = deque([root])

        left_val: int | None = None

        while q:
            # start a new level, refresh left value
            left_val = None

            for _ in range(len(q)):
                curr = q.popleft()

                if left_val == None:
                    left_val = curr.val

                if curr.left:
                    q.append(curr.left)

                if curr.right:
                    q.append(curr.right)

        return left_val
                