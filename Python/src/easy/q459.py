class Solution:
    """
    Leetcode 459: Repeated Substring Pattern
    """

    def repeatedSubstringPattern(self, s: str) -> bool:
        # if s contains a constructing substring, double s and remove head and tail char will contains at least one s
        double_s = s[1:] + s[:len(s)-1]
        return self.in_haystack(double_s,s)

    def in_haystack(self, needle, haystack) -> bool:
        # KMP
        next = [0] * len(needle)

        j = 0
        for i in range(1, len(needle)):
            while j > 0 and needle[i] != needle[j]: # prefix != suffix, rollback
                j = next[j-1]

            if needle[j] == needle[i]:
                j += 1

            next[i] = j

        j = 0
        for i in range(len(haystack)):
            while j > 0 and haystack[i] != needle[j]:
                j = next[j-1]

            if haystack[i] == needle[j]:
                j += 1

            if j == len(needle):
                return True

        return False