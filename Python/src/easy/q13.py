class Solution:
    """
    Leetcode 13: Roman to Integer
    """

    def romanToInt(self, s: str) -> int:
        rtoi = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        }

        sum = 0
        for i in range(len(s)-1):
            if rtoi[s[i]] < rtoi[s[i+1]]:
                sum -= rtoi[s[i]]
            else:
                sum += rtoi[s[i]]
        
        sum += rtoi[s[-1]]

        return sum
    

if __name__ == "__main__":
    sol = Solution()
    print(sol.romanToInt("MMMCMXCIX"))