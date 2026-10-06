from typing import List

class Solution:
    """
    Leetcode 274: H-Index
    """

    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse=True)
        h_index = 0

        for i, cites in enumerate(citations):
            if cites >= i+1:
                h_index = i+1
        
        return h_index
    

if __name__ == "__main__":
    sol = Solution()
    print(sol.hIndex([1,3,1])) # 6,5,3,1,0 # 3,1,1