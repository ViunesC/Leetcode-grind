from typing import List

class Solution:
    """
    Leetcode 17: Letter Combinations of a Phone Number
    """

    def letterCombinations(self, digits: str) -> List[str]:
        dict = {'2':"abc", '3':"def", '4':"ghi", '5':"jkl", '6':"mno", '7': "pqrs", 
        '8':"tuv", '9':"wxyz"}

        cmb = [''] if digits else []

        for d in digits:
            cmb = [p + q for p in cmb for q in dict[d]]
        return cmb 
        
    

if __name__ == "__main__":
    solution = Solution()
    solution.letterCombinations("")