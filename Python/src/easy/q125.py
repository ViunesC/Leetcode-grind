class Solution:
    """
    Leetcode 125: Valid Palindrome
    """

    def isPalindrome(self, s: str) -> bool:
        if len(s) == 1:
            return True

        i, j = 0, len(s)-1
        while i <= j:
            if not s[i].isalnum():
                i += 1
                continue
            if not s[j].isalnum():
                j -= 1
                continue
            
            if s[i].isalpha() and s[j].isalpha():
                if s[i].lower() != s[j].lower():
                    return False
            elif s[i].isnumeric() and s[j].isnumeric():
                if s[i] != s[j]:
                    return False
            else:
                return False
            
            i += 1
            j -= 1
    
        return True