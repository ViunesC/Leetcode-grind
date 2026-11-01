from collections import deque


class Solution:
    """
    Leetcode 239: Sliding Window Maximum
    """

    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        q = deque() # Monotonic decreasing queue, where front is biggest element in the window
        result = []

        for i in range(k):
            self.update_q(q, nums, "push", i)
        result.append(nums[self.update_q(q, nums, "peek")])

        for i in range(k, len(nums)):
            if q and self.update_q(q, nums, "peek") < (i-k+1):
                self.update_q(q, nums, "pop")

            self.update_q(q, nums, "push", i)
            result.append(nums[self.update_q(q, nums, "peek")])

        return result


    def update_q(self, q: deque, nums: list[int], action: str, next: int | None = None) -> int | None:
        if action == "peek":
            return q[0]
        elif action == "pop": # when window slide right and biggest element are left out
            q.popleft()
        else:
            while q and next and nums[q[-1]] < nums[next]: # add to right of queue, keep replacing element smaller than next
                q.pop()
            q.append(next)


if __name__ == "__main__":
    sol = Solution()

    print(sol.maxSlidingWindow([1,3,1,2,0,5],3))