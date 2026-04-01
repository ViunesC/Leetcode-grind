import heapq
from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    """
    Leetcode 23: Merge k Sorted Lists
    """

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        merged = []

        for node in lists:
            while node:
                heapq.heappush(merged, node.val)
                node = node.next
        
        if not merged:
            return None
        
        result = ListNode(heapq.heappop(merged))
        p = result

        while merged:
            p.next = ListNode(heapq.heappop(merged))
            p = p.next

        return result