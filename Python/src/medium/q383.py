class Solution:
    """
    Leetcode 383: Ransom Note
    """
        
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        char_freq = [0] * 26

        for c in magazine:
            char_freq[ord(c)-97] += 1

        for c in ransomNote:
            if char_freq[ord(c)-97] == 0:
                return False
            char_freq[ord(c)-97] -= 1

        return True