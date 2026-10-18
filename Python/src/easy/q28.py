class Solution:
    """
    Leetcode 28: Find the Index of the First Occurrence in a String
    """

    def strStr(self, haystack: str, needle: str) -> int:
        """
        KMP 核心：复用已匹配的信息，避免重复比较，时间复杂度 O(n + m)。

        next[i]：needle[0:i+1] 的最长相等前后缀的长度。
        构造 next：用 i 遍历 needle，j 表示当前相等前后缀的长度。
            - 相等：j += 1，前后缀长度增加
            - 不等：j = next[j-1]，尝试更短的相等前后缀，直到匹配或 j=0
            - 记录 next[i] = j

        实际匹配：i 遍历 haystack，j 指向 needle 中待匹配的字符。
            - 相等：j += 1
            
            - 不等：利用 next[j-1] 回退 j，复用之前的匹配结果
            - j == len(needle)：匹配成功，起始下标为 i-j+1
        """

        next = self.get_next(needle)

        j = 0
        for i in range(len(haystack)):
            while j > 0 and haystack[i] != needle[j]:
                j = next[j-1]
            if haystack[i] == needle[j]:
                j += 1
            if j == len(needle):
                return i - j + 1

        return -1

    def get_next(self, needle):
        """KMP O(M+N)"""
        next = [0] * len(needle)

        j = 0
        for i in range(1, len(needle)):
            while j > 0 and needle[j] != needle[i]:
                j = next[j-1]

            if needle[i] == needle[j]:
                j += 1
            next[i] = j

        return next