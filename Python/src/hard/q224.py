from collections import deque

class Solution:
    """
    Leetcode 224: Basic Calculator
    """

    def calculate(self, s: str) -> int:
        stack = deque()

        sign = 1
        result, curr = 0, 0

        for chr in s:
            if chr == " ":
                continue
            elif chr.isnumeric():
                curr = curr * 10 + int(chr)
            elif chr == "(":
                # save curr and sign to stack to be retrieved later
                stack.append(result)
                stack.append(sign)
                sign = 1
                result = 0
            elif chr == ")":
                # add current number and retrieve saved result from stack
                result += sign * curr
                curr = 0
                result *= stack.pop()
                result += stack.pop()
            else:
                # add current number, then set sign for next number
                result += sign * curr
                curr = 0
                sign = 1 if chr == "+" else -1 # add or minus
        result += sign * curr # last operation

        return result