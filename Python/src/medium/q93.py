class Solution:
    """
    Leetcode 93: Restore IP Addresses
    """
    segment: list[str]
    results: list[str]

    def restoreIpAddresses(self, s: str) -> list[str]:
        self.segment, self.results = [],[]

        self.backTrack(s, 0)
        return self.results

    def backTrack(self, s:str, start:int):
        if len(self.segment) == 4 and start >= len(s):
            # found a valid slicing
            self.results.append(".".join(self.segment))
            return
        elif len(self.segment) > 4:
            return

        for i in range(start, min(start+3, len(s))):
            # greater than 255 or has leading 0
            if int(s[start:i+1]) > 255 or (len(s[start:i+1]) > 1 and s[start:i+1].startswith("0")):
                break

            self.segment.append(s[start:i+1])
            self.backTrack(s, i+1)
            self.segment.pop()


if __name__ == "__main__":
    sol = Solution()
    print(sol.restoreIpAddresses("0000"))