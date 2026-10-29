from collections import deque


class Solution:
    """
    Leetcode 1047: Remove All Adjacent Duplicates In String
    """

    def removeDuplicates(self, s: str) -> str:
        stack = deque()

        for c in s:
            if stack and stack[-1] == c:
                stack.pop()
            else:
                stack.append(c)

        result = list(stack)

        return "".join(result)


if __name__ == "__main__":
    sol = Solution()
    print(sol.removeDuplicates("abbaca"))