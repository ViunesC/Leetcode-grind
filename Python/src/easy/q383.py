class Solution:
    """
    Leetcode 383: Ransom Note
    """

    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        mag_chars = [0] * 26

        for c in magazine:
            mag_chars[ord(c)-97] += 1

        for c in ransomNote:
            if mag_chars[ord(c)-97] < 1:
                return False
            else:
                mag_chars[ord(c)-97] -= 1

        return True