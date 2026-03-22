from collections import OrderedDict

class LRUCache:
    """
    Leetcode 146: LRU Cache
    """

    def __init__(self, capacity: int):
        self.size = capacity
        self.cache = OrderedDict() # ordered dict for fast O(1) access and as queue, where head of queue is least-recently-used element

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        
        self.cache.move_to_end(key) # move access element to end (most-recently used)
        return self.cache[key]
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            del self.cache[key] # if exist delete and re-insert it (move to end)
        
        self.cache[key] = value

        if len(self.cache) > self.size:
            self.cache.popitem(last=False) # pop LRU element if cache is full


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)