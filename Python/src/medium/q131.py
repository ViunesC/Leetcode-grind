class Solution:
    """
    Leetcode 131: Palindrome Partitioning
    """

    path: list[str]
    results: list[list[str]]

    def partition(self, s: str) -> list[list[str]]:
        self.path = []
        self.results = []

        self.backTrack(s, 0)

        return self.results

    def backTrack(self, s, start):
        if start >= len(s):
            # found valid slicing
            self.results.append(self.path.copy())
            return

        for i in range(start, len(s)):
            # if substring is palindrome, add to path
            sb = s[start:i+1]

            print(sb)

            if self.isPalindrome(sb):
                self.path.append(sb)
            else:
                continue

            self.backTrack(s, i+1)
            self.path.pop()

    def isPalindrome(self, s) -> bool:
        i, j = 0, len(s)-1

        while i<=j:
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1

        return True


if __name__ == "__main__":
    sol = Solution()

    sol.partition("aab")