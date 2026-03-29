from typing import List
from collections import deque

class Solution:
    """
    Leetcode 127: Word Ladder
    """

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        words = set(wordList)

        if endWord not in words:
            return 0
        
        # initialize bfs
        queue = deque([beginWord])
        searched = set()
        curr_layer_len, next_layer_len = 1, 0
        steps = 0

        while queue:
            curr = queue.popleft()
            curr_layer_len -= 1

            for i in range(len(beginWord)):
                for offset in range(26):
                    c = chr(ord('a') + offset)

                    if c != curr[i]:
                        curr_chars = list(curr)
                        curr_chars[i] = c
                        next = "".join(curr_chars)

                        if next == endWord:
                            return steps + 2

                        if next not in searched and next in words:
                            next_layer_len += 1
                            searched.add(next)
                            queue.append(next)
            
            if curr_layer_len == 0:
                curr_layer_len = next_layer_len
                next_layer_len = 0
                steps += 1
        
        return 0
    

if __name__ == "__main__":
    sol = Solution()
    print(sol.ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))