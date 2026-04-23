class Solution:
    """
    Leetcode 12: Integer to Roman
    """

    def intToRoman(self, num: int) -> str:
        # 3999:
        # 3 * 10^(n-1) = 3000 = MMM
        # 3999 % 10^(n-1) = 999
        # 9 * 10^(n-1) = 900 = CM
        # 999 % 10^(n-1) = 99
        # 1234:
        # 1000 = M
        # 200 = CC
        # 30 = XXX
        # 4 = IV
        # 1600:
        # M
        # 

        itor = {
            1:"I",
            5:"V",
            10:"X",
            50:"L",
            100:"C",
            500:"D",
            1000:"M",
            4:"IV",
            9:"IX",
            40:"XL",
            90:"XC",
            400:"CD",
            900:"CM"
        }

        results = []
        while num > 0:
            num_str = str(num)
            n = (10**(len(num_str)-1))

            curr = int(num_str[0]) * n
            if curr in itor:
                results.append(itor[curr])
            else:
                if curr > 5 * n: # 5+, 50+, 500+
                    results.append(itor[5*n])
                    curr -= 5*n
                
                while curr > 0:
                    results.append(itor[n])
                    curr -= n
            num %= n
        
        return ''.join(results)


if __name__ == "__main__":
    sol = Solution()
    print(sol.intToRoman(7))