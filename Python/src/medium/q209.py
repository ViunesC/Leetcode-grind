from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left, right = 0, 0
        min_len = 1000001
        cum_sum = 0

        while True:
            # if cum_len < target
            # if not out of right end, slide right, else break
            if cum_sum < target:
                if right < len(nums):
                    cum_sum += nums[right]
                    right += 1
                else:
                    break
            # if cum_len >= target, calculate, then slide left
            else:
                min_len = min(min_len, right - left)
                # print(f"subarray={nums[left:right+1]}, sum={cum_sum}")
                cum_sum -= nums[left]
                left += 1
        
        return min_len if min_len != 1000001 else 0

if __name__ == "__main__":
    sol = Solution()
    print(sol.minSubArrayLen(7, [2,3,1,2,4,3]))