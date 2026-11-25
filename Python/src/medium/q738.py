class Solution:
    """
    Leetcode 738: Monotone Increasing Digits
    """

    def monotoneIncreasingDigits(self, n: int) -> int:
        # starting from rightmost digit we compare pair of digits backward
        # if left digit > right digit, we decrease left digit by 1
        # then set right digit AND all digit to the right to 9

        digits = []
        while n > 0:
            digits.insert(0, n % 10)
            n //= 10

        for i in range(len(digits)-2, -1, -1):
            if digits[i] > digits[i+1]:
                digits[i] -= 1
                for j in range(i+1, len(digits)):
                    digits[j] = 9

        result = 0
        for i,d in enumerate(digits):
            result += d * 10**(len(digits)-i-1)

        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.monotoneIncreasingDigits(332))