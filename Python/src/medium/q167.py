from typing import List

class Solution:
    """
    Leetcode 167: Two Sum II - Input Array Is Sorted
    """

    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # Binary search: O(nlogn)
        # for idx1, num in enumerate(numbers):
        #     idx2 = self.binarySearch(numbers, target - num)
            
        #     if idx2 != -1 and idx1 != idx2:
        #         result = [idx1+1, idx2+1] if idx2 > idx1 else [idx2+1, idx1+1]
        #         return result
        
        # return [-1, -1]

        i,j = 0, len(numbers)-1

        while i != j and numbers[i] + numbers[j] != target:
            if numbers[i] + numbers[j] > target:
                j -= 1
            else:
                i += 1
        
        return [i+1,j+1]


    # def binarySearch(self, numbers: List[int], target: int) -> int:
    #     left, right = 0, len(numbers)-1

    #     while right >= left:
    #         mid = left + (right - left) // 2

    #         if numbers[mid] == target:
    #             return mid
    #         elif numbers[mid] < target:
    #             left = mid + 1
    #         else:
    #             right = mid - 1
        
    #     return -1


if __name__ == "__main__":
    sol = Solution()
    print(sol.twoSum([2,3,4], 6))