from typing import List
from collections import Counter

class Solution:
    """
    Leetcode 169: Majority Element
    """

    def majorityElement(self, nums: List[int]) -> int:
        # Using collections.Counter
        # O(N) time with O(N) space
        # counter = Counter(nums).most_common(1)
        # return counter[0][0]
        
        # Voting algorithm O(1) space optimized
        result = nums[0]
        freq = 1
        for i in range(1, len(nums)):
            if freq == 0:
                result = nums[i] # freq decreased to 0, not a majority element
            
            if result == nums[i]:
                freq += 1
            else:
                freq -= 1
        
        return result