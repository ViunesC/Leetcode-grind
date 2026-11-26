# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Leetcode 968: Binary Tree Cameras
    """

    count: int

    def minCameraCover(self, root: TreeNode | None) -> int:
        # greedy: start from leaf nodes and let them be covered by parent nodes
        # local optimum: no cam on leaf nodes, only on parent node of them
        # global optimum: only intermediate nodes have cam installed, minimize need
        self.count = 0

        if self.traverse(root) == 0:
            # root was not covered, install one last camera
            self.count += 1

        return self.count

    def traverse(self, root: TreeNode | None) -> int:
        # postorder traversal
        # 0: not covered
        # 1: has camera
        # 2: covered

        if not root:
            # mark as covered (so we dont install cam on leaf node)
            return 2

        left = self.traverse(root.left)
        right = self.traverse(root.right)

        # check case
        if left == 0 or right == 0:
            # 情况2：左或者右子节点至少有一个没有覆盖，父节点应该装摄像头，返回有摄像头，摄像头数+1
            self.count += 1
            return 1
        elif left == 1 or right == 1:
            # 情况3：左和右子节点都有覆盖，且至少有一个节点有摄像头，父节点被覆盖，返回有覆盖
            return 2
        else:
            # 情况1：左子节点&右子节点都有覆盖，那左右子节点的子节点有摄像头，返回没有覆盖（父节点）
            return 0