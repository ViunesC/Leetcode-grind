class Solution:
    """
    Leetcode 455: Assign Cookies
    """
        
    def findContentChildren(self, g: list[int], s: list[int]) -> int:
        g.sort()
        s.sort()

        j = 0
        count = 0
        for exp in g:
            while j < len(s) and s[j] < exp:
                j += 1

            if j == len(s):
                break
            count += 1
            j += 1

        return count