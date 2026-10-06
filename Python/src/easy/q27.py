class Solution:
    """
    Leetcode 27: Remove Element
    """
    
    def removeElement(self, nums: list[int], val: int) -> int:
        slow, fast = 0,0

        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
                
            fast += 1

        return slow


if __name__ == "__main__":
    sol = Solution()
    arr = [0,1,2,2,3,0,4,2]
    print(sol.removeElement(arr, 5))
    print(arr)