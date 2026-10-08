class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    """
    Leetcode 203: Remove Linked List Elements
    """

    def removeElements(self, head: ListNode | None, val: int) -> ListNode | None:
        if not head:
            return None

        dummy = ListNode(-1, head)
        
        p = dummy

        while p != None:
            while p.next and p.next.val == val:
                p.next = p.next.next

            p = p.next

        return dummy.next


if __name__ == "__main__":
    sol = Solution()

    h = ListNode(1, ListNode(1, ListNode(1, ListNode(1, ListNode(1, None)))))

    h1 = sol.removeElements(h, 1)

    p = h1
    while p != None:
        print(p.val)
        p = p.next