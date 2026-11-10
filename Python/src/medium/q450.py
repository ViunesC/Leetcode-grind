# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    """
    Leetcode 450: Delete Node in a BST
    """

    def deleteNode(self, root: TreeNode | None, key: int) -> TreeNode | None:
        if not root:
            return

        prev = None # previous node of to-be-deleted node
        curr = root

        while (curr):
            if key > curr.val:
                prev = curr
                curr = curr.right
            elif key < curr.val:
                prev = curr
                curr = curr.left
            else:
                break

        node = self.deleteOne(curr, key)

        if not prev: # target is root
            return node

        if prev.left and prev.left.val == key:
            prev.left = node
        elif prev.right and prev.right.val == key:
            prev.right = node

        return root
        

    def deleteOne(self, root: TreeNode | None, key: int) -> TreeNode | None:
        # case 1: not found (visited empty node)
        if not root:
            return root

        # case 2: found, left and right children are both empty
        if root.val == key and ( not root.left and not root.right):
            return None

        # case 3: found, left children is not empty, right is empty
        if root.val == key and root.left and not root.right:
            return root.left

        # case 4: found, right is not empty
        if root.val == key and root.right and not root.left:
            return root.right

        # case 5: found, both are not empty
        if root.val == key:
            curr = root.right
            while curr.left: # traverse to leftmost leaf of right child
                curr = curr.left
            
            curr.left = root.left
            root.left = None

            return root.right