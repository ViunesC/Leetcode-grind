from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 230: Kth Smallest Element in a BST
    """

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # brute-force O(nlogn)
        # nodes = []

        # queue = deque()
        # queue.append(root)

        # while queue:
        #     n = queue.popleft()
        #     nodes.append(n.val)
        #     if n.left:
        #         queue.append(n.left)
        #     if n.right:
        #         queue.append(n.right)
        
        # return sorted(nodes)[k-1]

        # bst-optimized: O(n)
        self.nodes = []

        self.traverse(root)

        return self.nodes[k-1]
    
    def traverse(self, root: Optional[TreeNode]):
        if not root:
            return
        
        self.traverse(root.left)
        self.nodes.append(root.val)
        self.traverse(root.right)