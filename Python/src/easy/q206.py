# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    """
    Leetcode 206: Reverse Linked List
    """

    def reverseList(self, head: ListNode | None) -> ListNode | None:
        if not head:
            return None
        elif not head.next:
            return head

        slow, fast, tmp = head, head.next, None

        while fast:
            # slow -> fast -> tmp
            # slow <- fast <- tmp
            # . <- slow <- fast
            if not tmp:
                slow.next = None

            tmp = fast.next
            fast.next = slow

            # move on
            slow = fast
            fast = tmp

        return slow


if __name__ == "__main__":
    sol = Solution()
    
    h = ListNode(1, ListNode(2, None))

    h1 = sol.reverseList(h)

    p = h1
    while p != None:
        print(p.val)
        p = p.next
    