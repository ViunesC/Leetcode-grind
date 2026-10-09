# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    """
    Leetcode 19: Remove Nth Node From End of List
    """

    def removeNthFromEnd(self, head: ListNode | None, n: int) -> ListNode | None:
        if not head or not head.next:
            return None
        
        p, q = head, head
        for _ in range(n):
            p = ListNode(-1, p)

        while q.next and p.next:
            q = q.next
            p = p.next

        if p.next:
            if p.val == -1:
                head = head.next
            else:
                p.next = p.next.next

        return head


if __name__ == "__main__":
    sol = Solution()

    h = ListNode(1, ListNode(2, None))

    h1 = sol.removeNthFromEnd(h, 2)

    p = h1
    while p != None:
        print(p.val)
        p = p.next