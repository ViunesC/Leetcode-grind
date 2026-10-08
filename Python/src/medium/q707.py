class Node:
    def __init__(self, val, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class MyLinkedList:
    """
    Leetcode 707: Design Linked List
    """

    def __init__(self):
        self.head: Node | None = None

    def get(self, index: int) -> int:
        p = self.head

        for _ in range(index):
            if not p:
                break
            p = p.next

        return p.val if p else -1

    def addAtHead(self, val: int) -> None:
        p = Node(val,None,self.head)
        self.head = p
        
    def addAtTail(self, val: int) -> None:
        p = self.head

        if not p:
            self.addAtHead(val)
            return

        while p.next:
            p = p.next

        p.next = Node(val)
        

    def addAtIndex(self, index: int, val: int) -> None:
        if index == 0:
            self.addAtHead(val)
            return

        p = self.head

        while p and index > 1:
            p = p.next
            index -= 1

        if p:
            p.next = Node(val,None,p.next)
        

    def deleteAtIndex(self, index: int) -> None:
        if index == 0 and self.head:
            self.head = self.head.next
            return

        p = self.head

        while p and index > 1:
            p = p.next
            index -= 1

        if p and p.next:
            p.next = p.next.next


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)