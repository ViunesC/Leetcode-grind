class Solution:
    """
    Leetcode 76: Minimum Window Substring
    """

    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""

        need = {}
        for char in t:
            need[char] = need.get(char, 0) + 1

        window = {}
        have = 0
        required = len(t)
        left = 0
        best_start = 0
        best_len = float("inf")

        for right, char in enumerate(s):
            window[char] = window.get(char, 0) + 1

            if char in need and window[char] <= need[char]:
                have += 1

            while have == required:
                curr_len = right - left + 1
                if curr_len < best_len:
                    best_start = left
                    best_len = curr_len

                left_char = s[left]
                window[left_char] -= 1

                if left_char in need and window[left_char] < need[left_char]:
                    have -= 1

                left += 1

        if best_len == float("inf"):
            return ""

        return s[best_start:best_start + best_len]


if __name__ == "__main__":
    sol = Solution()

    print(sol.minWindow("ADOBECODEBANC", "ABC"))
