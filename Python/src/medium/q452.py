class Solution:
    """
    Leetcode 452: Minimum Number of Arrows to Burst Balloons
    """

    def findMinArrowShots(self, points: list[list[int]]) -> int:
        points.sort(key=lambda x:x[0]) # sort by Xstart

        num_arrows = 1

        for i in range(1, len(points)):
            if points[i][0] > points[i-1][1]:
                num_arrows += 1
            else:
                # propagate minimum right interval to next element
                points[i][1] = min(points[i][1], points[i-1][1])

        return num_arrows


if __name__ == "__main__":
    sol = Solution()
    print(sol.findMinArrowShots([[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]))