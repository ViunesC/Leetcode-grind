class Solution:
    """
    Leetcode 202: Happy Number
    """

    def isHappy(self, n: int) -> bool:
        visited = set()

        sum = n
        while sum != 1:
            s = sum
            sum = 0
            while s != 0:
                sum += (s % 10) ** 2
                s = s // 10
            
            if sum in visited:
                return False

            # print("sum=",sum)
            visited.add(sum)

        return True


if __name__ == "__main__":
    sol = Solution()

    print(sol.isHappy(19))
            
            