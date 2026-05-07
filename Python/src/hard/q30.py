from typing import List
from collections import deque

class Solution:
    """
    Leetcode 30: Substring with Concatenation of All Words
    """
    # TODO: fix ts

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        # O(n^2) suboptimal

        if not s or not words:
            return []

        results = []
        word_len = len(words[0])
        window_len = word_len * len(words)

        word_freq = {}

        for word in words:
            word_freq[word] = word_freq.get(word, 0) + 1
        
        for i in range(len(s) - window_len): # for # of windows in s
            substr_freq = {}
            j = i # inner needle, check every chars in windows

            while j < i + window_len:
                next_word = s[j:j+word_len]

                if next_word not in word_freq:
                    break

                substr_freq[next_word] = substr_freq.get(next_word, 0) + 1

                if substr_freq[next_word] > word_freq[next_word]:
                    break
                
                j += word_len

            if j == i + window_len:
                results.append(i)

        return results


if __name__ == "__main__":
    sol = Solution()

    print(sol.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", ["fooo","barr","wing","ding","wing"]))