class Solution:
    """
    Leetcode 135: Candy
    """

    def candy(self, ratings: list[int]) -> int:
        # two-pass
        candies = [1] * len(ratings) # min 1 candy

        # left->right, look left neighbour
        for i in range(len(ratings)):
            if i > 0 and ratings[i] > ratings[i-1] and candies[i] <= candies[i-1]:
                candies[i] = candies[i-1] + 1

        # right->left, look right neighbour
        for i in range(len(ratings)-1, -1,-1):
            if i < len(ratings)-1 and ratings[i] > ratings[i+1] and candies[i] <= candies[i+1]:
                candies[i] = candies[i+1] + 1

        tot = 0
        for c in candies:
            tot += c

        return tot


if __name__ == "__main__":
    sol = Solution()
    print(sol.candy([3,4,5,4,3,1]))