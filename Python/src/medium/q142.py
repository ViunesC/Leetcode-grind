from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    """
    Leetcode 142: Linked List Cycle II
    """

    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        slow, fast = head, head

        while fast:
            fast = fast.next
            if not fast:
                break
            fast = fast.next

            slow = slow.next

            if slow == fast:
                # intersected
                p = head

                while p != slow:
                    p = p.next
                    slow = slow.next

                return p

        return None