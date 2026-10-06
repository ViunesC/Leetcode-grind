from typing import List

class Solution:
    """
    Leetcode 14: Longest Common Prefix
    """

    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        result = ""
        first, last = strs[0], strs[-1]

        for i in range(min(len(first), len(last))):
            if first[i] != last[i]:
                break
            
            result += first[i]
        
        return result