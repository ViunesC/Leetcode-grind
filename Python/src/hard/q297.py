from typing import Optional
from collections import deque

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    """
    Leetcode 297: Serialize and Deserialize Binary Tree
    """

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return ""

        res = []

        queue = deque([root])

        while queue:
            node = queue.popleft()

            if node:
                res.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
            else:
                res.append("null")
        
        return ",".join(res)
        

    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "":
            return None

        nodes = data.split(",")
        root = TreeNode(int(nodes[0]))

        queue = deque([root])
        index = 1

        while index < len(nodes):
            node = queue.popleft()

            node_val_str = nodes[index]
            if node_val_str != "null":
                node.left = TreeNode(int(node_val_str))
                queue.append(node.left)
            
            index += 1

            node_val_str = nodes[index]
            if node_val_str != "null":
                node.right = TreeNode(int(node_val_str))
                queue.append(node.right)

            index += 1
        
        return root

        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))