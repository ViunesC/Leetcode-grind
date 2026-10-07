class Solution:
    """
    Leetcode 59: Spiral Matrix II
    """

    def generateMatrix(self, n: int) -> list[list[int]]:
        m = [[0] * n for _ in range(n)]

        loop, offset = n // 2, 1
        start_r,start_c,i = 0,0,1
        while loop > 0:
            r = start_r
            c = start_c

            while c < n - offset:
                m[r][c] = i
                i += 1
                c += 1
            # print(m)

            while r < n - offset:
                m[r][c] = i
                r += 1
                i += 1
            # print(m)

            while c > start_c:
                m[r][c] = i
                c -= 1
                i += 1
            # print(m)

            while r > start_r:
                m[r][c] = i
                r -= 1
                i += 1
            # print(m)

            start_r += 1
            start_c += 1

            offset += 1
            loop -= 1

        if n % 2 == 1:
            m[n//2][n//2] = i

        return m


if __name__ == "__main__":
    sol = Solution()
    print(sol.generateMatrix(3))