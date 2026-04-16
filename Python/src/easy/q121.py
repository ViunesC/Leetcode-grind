from typing import List

class Solution:
    """
    Leetcode 121: Best Time to Buy and Sell Stock
    """

    def maxProfit(self, prices: List[int]) -> int:
        '''Kanade's algorithm.'''
        buy_price = prices[0]
        profit = 0

        for price in prices:
            if price < buy_price: # if current price < lowest buying price, update
                buy_price = price
            if price - buy_price > profit: # if profit from buying stock at lowest point and sell today > max profit, update
                profit = price - buy_price

        return profit