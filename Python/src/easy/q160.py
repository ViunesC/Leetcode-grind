from typing import Optional

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    """
    Leetcode 160: Intersection of Two Linked Lists
    """

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        len_a, len_b = 1,1

        p = headA
        while p:
            p = p.next
            len_a += 1

        p = headB
        while p:
            p = p.next
            len_b += 1

        diff = len_a - len_b

        p,q = headA, headB

        for _ in range(abs(diff)):
            if diff > 0:
                p = p.next
            else:
                q = q.next

        while p and q:
            if p == q:
                return p

            p = p.next
            q = q.next

        return None