from typing import List

class Solution:
    """
    Leetcode 17: Letter Combinations of a Phone Number
    """

    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "":
            return []
        
        d2l = {
            "2":["a","b","c"], 
            "3":["d","e","f"],
            "4":["g","h","i"],
            "5":["j","k","l"],
            "6":["m","n","o"],
            "7":["p","q","r","s"],
            "8":["t","u","v"],
            "9":["w","x","y","z"]
        }

        letters = d2l.get(digits[0], [])
        next_result = self.letterCombinations(digits[1:])

        result = [cur+nxt for cur in letters for nxt in next_result] if next_result else letters

        return result
    

if __name__ == "__main__":
    solution = Solution()
    print(solution.letterCombinations("2345"))