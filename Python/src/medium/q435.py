class Solution:
    """
    Leetcode 435: Non-overlapping Intervals
    """

    def eraseOverlapIntervals(self, intervals: list[list[int]]) -> int:
        # sort by right bound
        intervals.sort(key=lambda x:x[1])

        end = intervals[0][1]
        # we count number of non-overlapping intervals, then subtract total number to get number of overlapping (need erase)
        non_overlapping = 1

        for i in range(1, len(intervals)):
            if intervals[i][0] >= end:
                non_overlapping += 1
                end = intervals[i][1]

        return len(intervals) - non_overlapping