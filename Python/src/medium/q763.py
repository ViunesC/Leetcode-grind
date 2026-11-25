class Solution:
    """
    Leetcode 763: Partition Labels
    """

    def partitionLabels(self, s: str) -> list[int]:
        # count last occurance of every char
        last_idx = [-1] * 26
        for i in range(len(s)):
            last_idx[ord(s[i])-97] = max(last_idx[ord(s[i])-97], i)

        # loop thru s and maintain a 'segment furtherest char index'
        left = 0
        right = 0
        results = []

        for i in range(len(s)):
            right = max(last_idx[ord(s[i])-97], right)

            if right == i:
                # if we looped to this index we found segment right bound, split
                results.append(right - left + 1)
                left = i + 1

        return results