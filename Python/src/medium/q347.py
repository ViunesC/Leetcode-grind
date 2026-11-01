from heapq import heappop, heappush


class Solution:
    """
    Leetcode 347: Top K Frequent Elements
    """

    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freq = {}

        for n in nums:
            freq[n] = freq.get(n,0) + 1

        # we do not use max heap bc each time we pop, we will pop the one with max freq, and we want to preserve it instead
        min_heap = [] # use min heap to sort freq mapping and retrieve

        for n, f in freq.items():
            heappush(min_heap, (f, n))
            if len(min_heap) > k: # keep under window len=k
                heappop(min_heap)

        result = [0] * k
        for i in range(k-1, -1, -1):
            result[i] = heappop(min_heap)[1]

        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.topKFrequent([1,1,1,2,2,3], 3))