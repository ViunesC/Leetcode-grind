class Solution:
    """
    Leetcode 541: Reverse String II
    """

    def reverseStr(self, s: str, k: int) -> str:
        i = 0
        chars = list(s)
        
        while i < len(chars):
            chars[i:i + k] = chars[i:i + k][::-1]
            i += k * 2

        return ''.join(chars)


if __name__ == "__main__":
    sol = Solution()

    print(sol.reverseStr("abcdefg", 2))