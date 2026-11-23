class Solution:
    """
    Leetcode 860: Lemonade Change
    """

    def lemonadeChange(self, bills: list[int]) -> bool:
        five, ten = 0, 0

        for b in bills:
            if b == 5:
                five += 1
            elif b == 10 and five > 0:
                ten += 1
                five -= 1
            elif b == 20:
                if ten > 0 and five > 0:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False
            else:
                return False

        return True