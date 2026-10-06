import random

class RandomizedSet:
    """
    Leetcode 380: Insert Delete GetRandom O(1)
    """

    def __init__(self):
        self.vals_table = {}
        self.vals = []

    def insert(self, val: int) -> bool:
        if val in self.vals_table:
            return False
        
        self.vals.append(val)
        self.vals_table[val] = len(self.vals)-1
        return True

    def remove(self, val: int) -> bool:
        if val not in self.vals_table:
            return False
        
        idx = self.vals_table[val]

        # swap
        self.vals[idx] = self.vals[-1]
        self.vals_table[self.vals[-1]] = idx

        # delete
        del self.vals_table[val]
        self.vals.pop()

        return True

    def getRandom(self) -> int:
        draw = random.randint(0,len(self.vals)-1)
        return self.vals[draw]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

if __name__ == "__main__":
    r = RandomizedSet()
    r.insert(0)
    r.insert(1)
    r.remove(0)
    r.insert(2)
    r.remove(1)
    print(r.getRandom())