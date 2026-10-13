class Solution:
    """
    Leetcode 454: 4Sum II
    """
        
    def fourSumCount(self, nums1: list[int], nums2: list[int], nums3: list[int], nums4: list[int]) -> int:
        first_two = []
        last_two = {}

        for a in nums1:
            for b in nums2:
                first_two.append(a+b)

        # print(first_two)

        for c in nums3:
            for d in nums4:
                last_two[c+d] = last_two.get(c+d,0) + 1

        # print(last_two)

        count = 0

        for v in first_two:
            if -v in last_two:
                count += last_two[-v]

        return count


if __name__ == "__main__":
    sol = Solution()
    print(sol.fourSumCount(nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]))