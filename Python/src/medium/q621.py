from typing import List

class Solution:
    """
    Leetcode 621: Task Scheduler
    """

    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 26

        for t in tasks:
            freq[ord(t) - ord("A")] += 1
        freq.sort()  # sort so freq[25] is the most frequent task

        # number of "frames" between first and last occurrence of the most frequent task
        # e.g. if A appears 3 times: [A _ _] [A _ _] A  → 2 frames (exclude last A)
        chunk = freq[25] - 1

        # worst case: every slot in every frame is idle → (freq_max - 1) * n idle slots
        idle = chunk * n

        # each other task fills some idle slots; cap at chunk because tasks
        # with the same max freq only fill one slot per frame (last occurrence
        # sits outside the frames, next to the final anchor task)
        for i in range(24, -1, -1):
            idle -= min(chunk, freq[i])

        # if idle > 0 we need filler intervals; if idle <= 0 tasks fill all gaps naturally
        return len(tasks) + idle if idle > 0 else len(tasks)


if __name__ == "__main__":
    sol = Solution()
    print(sol.leastInterval(['A','A','A','B','B','B'], 2))