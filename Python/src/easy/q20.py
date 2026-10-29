from collections import deque

class Solution:
    """
    Leetcode 20: Valid Parentheses
    """

    def isValid(self, s: str) -> bool:
        mapping = {
            "}":"{",
            "]":"[",
            ")":"("
        }

        stack = deque()

        for c in s:
            if c in mapping:
                if not stack or stack[-1] != mapping.get(c):
                    return False
                stack.pop()
            else:
                stack.append(c)

        return not stack