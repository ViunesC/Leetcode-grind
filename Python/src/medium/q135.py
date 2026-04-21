from typing import List

class Solution:
    """
    Leetcode 135: Candy
    """

    def candy(self, ratings: List[int]) -> int:
        candies = [1] * len(ratings)

        # two passes: check if candy assignment is good in both directions
        for i in range(1, len(ratings)): # left -> right
            if ratings[i] > ratings[i-1] and candies[i] <= candies[i-1]:
                candies[i] = candies[i-1] + 1
        
        for j in range(len(ratings)-2, -1, -1): # right -> left
            if ratings[j] > ratings[j+1] and candies[j] <= candies[j+1]:
                candies[j] = candies[j+1] + 1
        
        return sum(candies)