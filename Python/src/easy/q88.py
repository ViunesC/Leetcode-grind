from typing import List

class Solution:
    """
    Leetcode 88: Merge Sorted Array
    """

    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        p,q,k = m-1, n-1, m+n-1

        while q >= 0:
            if p >= 0 and nums1[p] > nums2[q]:
                nums1[k] = nums1[p]
                k -= 1
                p -= 1
            else:
                nums1[k] = nums2[q]
                k -= 1
                q -= 1


if __name__ == "__main__":
    sol = Solution()
    a1 = [1,2,3,0,0,0]
    sol.merge(a1, 3, [2,5,6], 3)
    print(a1)