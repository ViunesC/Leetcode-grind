from typing import List

class Solution:
    """
    Leetcode 68: Text Justification
    """

    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        start, line_len = 0, 0
        result = []

        for end in range(len(words)):
            if line_len + len(words[end]) <= maxWidth - ((end - start + 1)-1): # at least 1 space between each word
                line_len += len(words[end])
                continue

            # put words from start to end-1 into a line
            spaces, n_words = maxWidth - line_len, (end - 1) - start + 1

            if n_words > 1:
                n_space, extra = spaces // (n_words - 1), spaces % (n_words - 1)
            else:
                n_space, extra = 0, spaces

            line = []
            for i in range(start, end):
                line.append(words[i])
                if n_words == 1:
                    line.append(' ' * extra)
                elif extra > 0:
                    line.append(' ')
                    extra -= 1
                if i == end-1:
                    break
                line.append(' ' * n_space)
            
            result.append(''.join(line))
            
            line_len = len(words[end])
            start = end
        
        end = len(words)
        spaces, n_words = maxWidth - line_len, end - start + 1
        line = []
        for i in range(start, end):
            line.append(words[i])
            if i == end-1:
                break
            line.append(' ')
            spaces -= 1
        
        line += [' '] * spaces
        result.append(''.join(line))

        return result
    

if __name__ == "__main__":
    sol = Solution()
    print(sol.fullJustify(["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], 20))
