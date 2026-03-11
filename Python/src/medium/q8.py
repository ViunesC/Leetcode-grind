

class Solution:
    """
    Leetcode 8: String to Integer (atoi)
    """

    def myAtoi(self, s: str) -> int:
        if not s:
            return 0

        i = 0
        res_raw = ""
        is_negative = False
        zero_skipped = False
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        # skip leading whitespace
        while i < len(s) and s[i] == ' ':
            i += 1
        
        # check sign
        if i < len(s):
            if s[i] == '-':
                is_negative = True
                i += 1
            elif s[i] == '+':
                i += 1
        
        while i < len(s) and s[i].isnumeric():
            if not zero_skipped and s[i] != '0':
                zero_skipped = True
            
            if zero_skipped:
                res_raw += s[i]
            
            i += 1
        
        if res_raw == "":
            res = 0
        else:
            res = int(res_raw)
            if is_negative:
                res = -res
            
            if res <= INT_MIN:
                return INT_MIN
            if res >= INT_MAX:
                return INT_MAX

        return res