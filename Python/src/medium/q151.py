class Solution:
    """
    Leetcode 151: Reverse Words in a String
    """

    def reverseWords(self, s: str) -> str:
        words = s.split()
        words.reverse()
        
        return " ".join(words)

if __name__ == "__main__":
    sol = Solution()
    print(sol.reverseWords("the sky is blue"))