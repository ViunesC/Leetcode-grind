# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Leetcode 501: Find Mode in Binary Search Tree
    """

    results: set[int]
    max_count: int
    count: int
    prev: TreeNode | None

    def findMode(self, root: TreeNode | None) -> list[int]:
        self.results = set()
        self.max_count = 0
        self.count = 0
        self.prev = None
        
        self.traverse(root)

        return list(self.results)


    def traverse(self, root: TreeNode | None):
        # in order traversal - use the characteristics of BST: monotonic increasing
        # to compare adjacent node values, 
        # and use global counter and max_count to record current value freq and max freq

        if not root:
            return

        self.traverse(root.left)

        if self.prev and root.val == self.prev.val:
            self.count += 1
        else:
            self.count = 1

        self.prev = root

        if self.count >= self.max_count: 
            if self.count > self.max_count: # if current val freq > global maximum, it means that previous values are **NOT** mode
                self.max_count = self.count
                self.results.clear() # remove all previous mode candidates

            self.results.add(root.val)

        self.traverse(root.right)