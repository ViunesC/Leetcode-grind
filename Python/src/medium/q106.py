# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 106: Construct Binary Tree from Inorder and Postorder Traversal
    """

    def buildTree(self, inorder: list[int], postorder: list[int]) -> TreeNode | None:
        if not inorder or not postorder:
            return None
        
        # slice in based on post
        splice_point = inorder.index(postorder[-1])
        left_in, right_in = inorder[:splice_point], inorder[splice_point+1:]

        # slice post based on in
        left_post, right_post = postorder[:len(left_in)], postorder[len(left_in):len(postorder)-1]

        node = TreeNode(inorder[splice_point])

        # recursively slice and build child nodes
        node.left = self.buildTree(left_in, left_post)
        node.right = self.buildTree(right_in, right_post)

        return node