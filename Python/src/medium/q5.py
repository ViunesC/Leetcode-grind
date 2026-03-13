

class Solution:
    """
    Leetcode 5: Longest Palindromic Substring
    """

    def longestPalindrome(self, s: str) -> str:
        # dp solution:
        # 1. we maintain a 2D matrix dp[i][j] = [i, j] (inclusive) is a palindrome or not
        # 2. the state transformation formula is: dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
        # 3. to go over matrix we need to keep track of *diff*, which is j-i
        #   for all diff = 0 we set dp[i][j] = True, then for all diff = 1 we check if s[i] == s[j], if true then it's a palindrome
        #   and dp[i][j] = True
        #
        # 4. from diff 2 and onward, we check the substring with above mentioned formula
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        longest = [0, 0]

        for i in range(n):
            dp[i][i] = True
        
        for i in range(n-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = True
                longest = [i, i+1]

        for diff in range(2, n):
            for i in range(n-diff):
                j = i + diff
                if s[i] == s[j] and dp[i+1][j-1]:
                    dp[i][j] = True
                    longest = [i, j]
        
        i, j = longest

        return s[i:j+1]