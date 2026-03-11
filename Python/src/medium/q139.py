from typing import List

class Solution:
    """
    Leetcode 139: Word Break
    """

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False for _ in range(len(s))]
        words = set(wordDict)

        for i in range(len(s)):
            if s[:i+1] in words:
                dp[i] = True
            else:
                for j in range(i-1, -1, -1):
                    if dp[j] and s[j+1:i+1] in words:
                        dp[i] = True
        
        return dp[len(s)-1]