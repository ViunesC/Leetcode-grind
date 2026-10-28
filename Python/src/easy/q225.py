from queue import Queue


class MyStack:
    """
    Leetcode 232: Implement Stack using Queues
    """

    def __init__(self):
        self.queue = Queue()

    def push(self, x: int) -> None:
        self.queue.put(x)

    def pop(self) -> int:
        count = self.queue.qsize()

        for _ in range(count-1):
            self.queue.put(self.queue.get())

        return self.queue.get()

    def top(self) -> int:
        count = self.queue.qsize()
        
        for _ in range(count-1):
            self.queue.put(self.queue.get())

        x = self.queue.get()
        self.queue.put(x)
        return x
        
    def empty(self) -> bool:
        return self.queue.empty()


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()