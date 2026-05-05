class Solution:
    """
    Leetcode 3: Longest Substring Without Repeating Characters
    """

    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        slow = 0
        
        chars = set([s[0]])
        result = 1

        for fast in range(1, len(s)):
            if s[fast] in chars:
                while s[slow] != s[fast]:
                    chars.remove(s[slow])
                    slow += 1
                slow += 1
            chars.add(s[fast])

            result = max(result, len(chars))
            
        
        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.lengthOfLongestSubstring(""))