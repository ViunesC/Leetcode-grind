class Solution:
    """
    Leetcode 406: Queue Reconstruction by Height
    """

    def reconstructQueue(self, people: list[list[int]]) -> list[list[int]]:
        # sort people by reverse height (highest first) then k
        people.sort(key=lambda x: (-x[0], x[1]))
        q = []

        # insert people into a queue (greedy approach)
        # since people is sorted, at same height people with smaller k will be inserted first
        for p in people:
            q.insert(p[1], p)

        return q