# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 669: Trim a Binary Search Tree
    """

    def trimBST(self, root: TreeNode | None, low: int, high: int) -> TreeNode | None:
        if not root:
            return None

        if root.val < low: # root's val < lowest bound, discard left subtree and search only right
            right = self.trimBST(root.right, low, high)
            return right # return possible node in right subtree (discard root and root's left subtree)

        if root.val > high: # root's val > highest bound, discard right subtree and search only left
            left = self.trimBST(root.left, low, high)
            return left # return possible node in left subtree (discard root and root's right subtree)

        # root in both bound, now recursively trim it's subtrees
        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)

        return root