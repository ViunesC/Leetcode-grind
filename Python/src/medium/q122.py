class Solution:
    """
    Leetcode 122: Best Time to Buy and Sell Stock II
    """

    def maxProfit(self, prices: list[int]) -> int:
        # collect gain
        result = 0

        for i in range(len(prices)):
            if i > 0:
                result += max(prices[i]-prices[i-1], 0)

        return result