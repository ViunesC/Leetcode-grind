class Solution:
    """
    Leetcode 6: Zigzag Conversion
    """

    def convert(self, s: str, numRows: int) -> str:
        # paypalishiring: 14
        # 14 / [3 + (3-2)] = 3...2
        # we need 3 2x3 matrix and 1 1x2 matrix -> 3 2x3 matrix + 1 1*3 -> 7*3
        # n / nR + (nR-2) = k...m, thus we need k (1+(nR-2))*nR matrices 
        # and if m != 0 we need one 1*nR -> k(nR-1)+1*nR matrix

        if numRows >= len(s) or numRows == 1:
            return s
        
        k = len(s) // (numRows + (numRows - 2))
        m = len(s) % (numRows + (numRows - 2))

        if len(s) < numRows + (numRows - 2):
            num_cols = 1 + (numRows + (numRows - 2) % len(s))
        else:
            num_cols = k * (numRows-1) # full zigzag pattern
            num_cols = num_cols + 1 if m <= numRows else num_cols + 1 + (m - numRows) # residual

        matrix = [[' ' for _ in range(num_cols)] for _ in range(numRows)]

        r, c = 0, 0
        diag_remaining = 0

        for chr in s:
            matrix[r][c] = chr
            # print(matrix)
            if r == numRows-1:
                diag_remaining = numRows - 1
                
            if diag_remaining != 0:
                c += 1
                r -= 1
                diag_remaining -= 1
            else:
                r += 1
        
        result = []

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] != ' ':
                    result.append(matrix[i][j])

        return ''.join(result)




if __name__ == "__main__":
    sol = Solution()
    print(sol.convert("PAYPALISHIRING", 5))