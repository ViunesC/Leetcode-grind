class Solution:
    """
    Leetcode 349: Intersection of Two Arrays
    """

    def intersection(self, nums1: list[int], nums2: list[int]) -> list[int]:
        s = set(nums1)

        res = {n for n in nums2 if n in s}

        return list(res)


if __name__ == "__main__":
    sol = Solution()
    print(sol.intersection([1,2,1], [1,2,2,2,2]))
