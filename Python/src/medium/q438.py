from typing import List

class Solution:
    """
    Leetcode 438: Find All Anagrams in a String
    """

    def findAnagrams(self, s: str, p: str) -> List[int]:
        # hashmap for storing p and checking if s has angram
        # sliding window for holding single anagram
        # first move end pointer to right to cover anagram
        # if anagram found, record the begin pointer as pos
        # then move begin pointer to right to refill hashmap

        mapping = {}
        for _p in p:
            mapping[_p] = mapping.get(_p, 0) + 1
        
        counter = len(mapping)
        begin, end = 0, 0 # sliding window
        results = []

        while end < len(s):
            c = s[end]
            if c in mapping:
                mapping[c] -= 1
                if mapping[c] == 0:
                    counter -= 1
            end += 1

            while counter == 0:
                tc = s[begin]
                if tc in mapping:
                    mapping[tc] += 1
                    if mapping[tc] > 0:
                        counter += 1
                
                if end-begin == len(p):
                    results.append(begin)
                begin += 1
        
        return results


if __name__ == "__main__":
    sol = Solution()
    print(sol.findAnagrams("aab", "ab"))