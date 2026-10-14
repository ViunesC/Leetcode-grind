class Solution:
    """
    Leetcode 18: 4Sum
    """

    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:
        nums.sort()
        results = []

        for a in range(len(nums)):
            if a > 0 and nums[a] == nums[a-1]:
                continue
            for b in range(a+1, len(nums)):
                if b > a+1 and nums[b] == nums[b-1]:
                    continue

                c,d = b+1, len(nums)-1

                while c < d:
                    t = nums[a] + nums[b] + nums[c] + nums[d]

                    if t > target:
                        d -= 1
                    elif t < target:
                        c += 1
                    else:
                        results.append([nums[a],nums[b],nums[c],nums[d]])
                        c += 1
                        while nums[c] == nums[c-1] and c < d:
                            c += 1

        return results