class Solution:
    """
    Leetcode 28: Find the Index of the First Occurrence in a String
    """

    def strStr(self, haystack: str, needle: str) -> int:
        i,j = 0,0

        next = self.get_next(needle)

        for i in range(len(haystack)):
            while j > 0 and haystack[i] != needle[j]:
                j = next[j-1] # rollback j to point to last postfix that is the proper prefix of needle
            
            if haystack[i] == needle[j]:
                j += 1
            
            if j == len(needle):
                return i - j + 1
        
        return -1

    def get_next(self, needle):
        """KMP O(M+N)"""
        next = [0] * len(needle)

        j = 0 # prefix
        for i in range(1, len(needle)): # postfix
            while j > 0 and needle[i] != needle[j]:
                j = next[j-1]
            
            if needle[i] == needle[j]:
                j += 1
            
            next[i] = j
        
        return next