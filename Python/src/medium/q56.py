class Solution:
    """
    Leetcode 56: Merge Intervals
    """

    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        intervals.sort(key=lambda x:x[0])

        results = [intervals[0]]
        for intv in intervals:
            if intv[0] <= results[-1][1]:
                # merge
                results[-1] = [results[-1][0], max(results[-1][1], intv[1])]
            else:
                results.append(intv)

        return results