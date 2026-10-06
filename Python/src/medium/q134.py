from typing import List

class Solution:
    """
    Leetcode 134: Gas Station
    """

    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # we will store two sums:
        # 1. currSum, representing the current run's remaining fuel (fuel obtained - fuel used)
        #   if at any point i, the currSum becomes negative, it means that starting from 0...i will lead to 
        #   negative fuel amount, which means that the car will stuck somewhere in between,
        #   thus we need to place start position to i+1 to continue checking.
        # 2. totalSum, representing the total remaining fuel. if this is negative after checking all stations
        #   it means that the car will stuck in between and cannot finish a full loop.
        curr_sum, total_sum, start = 0, 0, 0

        for i in range(len(gas)):
            curr_sum += gas[i] - cost[i]
            total_sum += gas[i] - cost[i]

            if curr_sum < 0: # stuck at i
                start = i + 1
                curr_sum = 0
        
        if total_sum < 0: # no loop possible
            return -1
        
        return start