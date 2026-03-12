from typing import Optional, List
from collections import deque 

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 199: Binary Tree Right Side View
    """

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.views = []
        self.bfs(root)
        return self.views

    def bfs(self, root:Optional[TreeNode]):
        if not root:
            return
        
        numCurr, numNext = 1,0
        queue = deque([root])

        while queue:
            curr = queue.popleft()
            numCurr -= 1

            if curr.left:
                queue.append(curr.left)
                numNext += 1
            if curr.right:
                queue.append(curr.right)
                numNext += 1

            if numCurr == 0:
                # right-most node
                self.views.append(curr.val)
                numCurr = numNext
                numNext = 0