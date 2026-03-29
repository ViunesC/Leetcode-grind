from heapq import (
    heappop,
    heappush
)

class MedianFinder:
    """
    Leetcode 295: Find Median from Data Stream
    """

    def __init__(self):
        self.lefts = [] # max-heap, top = biggest in left sub array
        self.rights = [] # min-heap, top = smallest in right sub array

    def addNum(self, num: int) -> None:
        heappush(self.lefts, -num)
        heappush(self.rights, -heappop(self.lefts)) # left contains big element belongs to right, pop it and push to right

        if len(self.rights) > len(self.lefts): # if right has more element than left, pop it and push to left
            heappush(self.lefts, -heappop(self.rights))

    def findMedian(self) -> float:
        if len(self.lefts) == len(self.rights): # length of array is even, pick average of largest in left and smallest in right
            return (-self.lefts[0] + self.rights[0]) / 2
        else:
            return -self.lefts[0] # odd, pick largest in left


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()