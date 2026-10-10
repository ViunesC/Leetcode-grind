class Solution:
    """
    Leetcode 242: Valid Anagram
    """

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        freq = {}

        for c in s:
            freq[c] = freq.get(c, 0) + 1

        for c in t:
            c_f = freq.get(c, 0)
            
            if c_f == 0:
                return False
            else:
                freq[c] = c_f - 1

        return True


if __name__ == "__main__":
    sol = Solution()
    print(sol.isAnagram("anagram","nagaram"))