class Solution:
    """
    Leetcode 151: Reverse Words in a String
    """

    def reverseWords(self, s: str) -> str:
        # remove extra spaces
        s = s.strip()

        i = 0
        while i < len(s):
            if s[i] == " ":
                i += 1
                while i < len(s) and s[i] == " ":
                    s = s[:i] + s[i+1:]
            i += 1

        # reverse whole string
        s = self._reverse(s, 0, len(s)-1)

        # print(s)

        # reverse each word
        start, end = 0, 0

        while True:
            while end < len(s) and s[end] != " ":
                end += 1

            if end >= len(s):
                s = self._reverse(s, start, end-1)
                break
            else:
                s = self._reverse(s, start, end-1)
                # print(s)
                end += 1 # skip space
                # print(start, end)
                start = end
        
        # print(s)
        return s
        
    def _reverse(self, s, start, end):
        """Reverse part of the string s"""
        i, j = start, end

        while i < j:
            a, b = s[i], s[j]
            s = s[:i] + b + s[i+1:j] + a + s[j+1:]
            i += 1
            j -= 1
        
        return s



if __name__ == "__main__":
    sol = Solution()
    sol.reverseWords(" Hello   world ")
